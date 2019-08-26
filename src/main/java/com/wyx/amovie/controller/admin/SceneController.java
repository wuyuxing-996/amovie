package com.wyx.amovie.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.entity.SceneForm;
import com.wyx.amovie.service.MovieService;
import com.wyx.amovie.service.SceneService;
import com.wyx.amovie.utils.Msg;
import com.wyx.amovie.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author wyx
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/scenes")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity getScene(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {
        Page<Scene> scene = PageHelper.startPage(page, size)
                .doSelectPage(() -> sceneService.getAll());
        return new ResponseEntity(scene.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}", params = "id")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Scene scene = sceneService.getById(id);
        return Result.checkObject(scene);
    }

    @PostMapping
    public ResponseEntity addScene(@RequestBody SceneForm sceneForm) {
        Scene scene = toScene(sceneForm);
        Movie movie = movieService.getById(scene.getMovieId());
        if (movie == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        scene.setMovieName(movie.getName());
        scene.setSeatNum(166);
        int result = sceneService.addScene(scene);
        return Result.checkAdd(result);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateScene(@PathVariable(value = "id") Integer id,
                                      @RequestBody SceneForm sceneForm) {
        Scene scene1 = sceneService.getById(id);
        Scene scene = toScene(sceneForm);
        if (scene1 == null) {
            Msg msg = Msg.fail().add("原因", "该场次不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        scene.setId(id);
        int result = sceneService.updateScene(scene);
        return Result.checkUpdate(result);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteScene(@PathVariable(value = "id") Integer id) {
        Scene scene = sceneService.getById(id);
        if (scene == null) {
            Msg msg = Msg.fail().add("原因", "该场次不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = sceneService.deleteScene(id);
        return Result.checkDelete(result);
    }

    /**
     * 获取场景类型
     *
     * @param sceneForm
     * @return
     */
    Scene toScene(SceneForm sceneForm) {
        Scene scene = new Scene();
/*        String[] seats = sceneForm.getBookedSeat();
        StringBuilder sb = new StringBuilder();
        for (String seat : seats) {
            sb.append(seat + "#");
        }
        String getSeats = sb.toString();*/
        BeanUtils.copyProperties(sceneForm, scene);
        /* scene.setBookedSeat(getSeats.substring(0, getSeats.length() - 1));*/
        return scene;
    }
}
