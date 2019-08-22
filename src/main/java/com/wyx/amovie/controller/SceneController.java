package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.entity.SceneVo;
import com.wyx.amovie.service.SceneService;
import com.wyx.amovie.utils.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * @author wyx
 */
@RestController
@RequestMapping(value = "/scenes")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @GetMapping
    public ResponseEntity getScene(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "2") Integer size) {
        Page<Scene> scene = PageHelper.startPage(page, size)
                .doSelectPage(() -> sceneService.getAll());
        return new ResponseEntity(scene.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Scene scene = sceneService.getById(id);
        if (scene != null) {
            return ResponseEntity.ok(scene);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity addScene(@RequestBody SceneVo sceneVo) {
        Scene scene = toScene(sceneVo);
        if (sceneService.addScene(scene) != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateScene(@PathVariable(value = "id") Integer id,
                                      @RequestBody SceneVo sceneVo) {
        Scene scene1 = sceneService.getById(id);
        Scene scene = toScene(sceneVo);
        if (scene1 == null) {
            Msg msg = Msg.fail().add("原因", "该场次不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        scene.setId(id);
        int result = sceneService.updateScene(scene);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteScene(@PathVariable(value = "id") Integer id) {
        Scene scene = sceneService.getById(id);
        if (scene == null) {
            Msg msg = Msg.fail().add("原因", "该场次不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = sceneService.deleteScene(id);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //获取场景类型
    Scene toScene(SceneVo sceneVo) {
        Scene scene = new Scene();
        String[] seats = sceneVo.getBookedSeat();
        StringBuilder sb = new StringBuilder();
        for (String seat : seats) {
            sb.append(seat + "#");
        }
        String getSeats = sb.toString();
        BeanUtils.copyProperties(sceneVo, scene);
        //TODO 时间转换
        scene.setShowtime(new Date());
        scene.setBookedSeat(getSeats.substring(0, getSeats.length() - 1));
        return scene;
    }
}
