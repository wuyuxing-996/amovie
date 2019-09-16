# 基于spring boot的电影订票网站
#部分功能动图如下

![image](https://github.com/wuyuxing-996/amovie/static/images/gif/booking.gif)
# Moive后台接口文档
合理使用以下类：

- org.springframework.http.ResponseEntity
- org.springframework.http.HttpStatus

使用POST/PUT发送JSON数据时，反序列化成对象需要在参数上加@RequestBody注解。

在浏览器上使用PUT/DELETE时会遇见跨域问题，原因在于浏览器遵循同源策略，具体信息见链接[https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS](https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Access_control_CORS)，使用Postman不会遇见此类问题，但需引起重视。

Postman的Header请设置成Content-Type: application/json，但凡请求数据为以下格式的，都需在Postman的Body下的raw下发送：
```json
{
	"name": ""
}
```

<a name="NIWtU"></a>
## 类别
<a name="zUXxQ"></a>
### 获取类别列表（分页）
请求方式：GET<br />请求地址：/categories<br />请求参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| page | int | 否，默认1 | 页码 |
| size | int | 否，默认20 | 每页大小 |

-----返回结构<br />HTTP状态码：200 -- 数据

<a name="TTWnL"></a>
### 获取所有类别列表（不分页）
请求方式：GET<br />请求地址：/categories/all<br />请求参数：无<br />返回数据格式：
```json
[
    {
        "id": 1,
        "name": "动作"
    },
    {
        "id": 2,
        "name": "爱情"
    }
]
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | 类别id |
| name | String | 是 | 类别名称 |

<a name="vwZM4"></a>
### 
<a name="Yxkt8"></a>
### 获取类别
请求方式：GET<br />请求地址：/categories/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 数据<br />HTTP状态码：404 -- 资源未找到

<a name="2HnSy"></a>
### 创建类别
请求方式：POST<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/categories<br />请求数据：
```json
{
	"name": "value"
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| name | String | 是 | 类别名称 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 创建失败

<a name="xC04H"></a>
### 修改类别
请求方式：PUT<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/categories/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | 类别id |

请求数据：
```json
{
	"name": "value"
}
```
| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| name | String | 是 | 类别名称 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 修改失败<br />HTTP状态码：404 -- 资源未找到

<a name="0sP3C"></a>
### 删除类别
请求方式：DELETE<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/categories/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | 类别id |

HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 删除失败<br />HTTP状态码：404 -- 资源未找到

<a name="AXk2N"></a>
## 资讯
<a name="JjGvj"></a>
### 获取资讯列表
请求方式：GET<br />请求地址：/news<br />请求参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| page | int | 否，默认1 | 页码 |
| size | int | 否，默认20 | 每页大小 |

HTTP状态码：200 -- 数据

<a name="j8Vr2"></a>
### 获取资讯
请求方式：GET<br />请求地址：/news/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 数据<br />HTTP状态码：404 -- 资源未找到

<a name="un5kI"></a>
### 创建资讯
请求方式：POST<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/news<br />请求数据：
```json
{
	"content": "value"
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| content | String | 是 | 资讯 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 创建失败

<a name="eVLmu"></a>
### 修改资讯
请求方式：PUT<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/news/{id}<br />请求数据：
```json
{
	"content": "value"
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| content | String | 是 | 资讯 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 修改失败<br />HTTP状态码：404 -- 资源未找到

<a name="cYIvG"></a>
### 删除资讯
请求方式：DELETE<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/news/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | String | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 删除失败<br />HTTP状态码：404 -- 资源未找到

<a name="2X0mp"></a>
## 电影
<a name="pNM4Q"></a>
### 获取电影列表
请求方式：GET<br />请求地址：/movies<br />请求参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| page | int | 否，默认1 | 页码 |
| size | int | 否，默认20 | 每页大小 |

HTTP状态码：200 -- 数据

<a name="ribnH"></a>
### 获取电影
请求方式：GET<br />请求地址：/movies/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 数据<br />HTTP状态码：404 -- 资源未找到

<a name="NqV8M"></a>
### 根据类别获取电影列表
请求方式：GET<br />请求地址：/movies<br />请求参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| categoryIds | int[] | 是 | 类型id |
| page | int | 否 | 页数 |
| size | int | 否 | 每页大小 |

-----返回结构<br />HTTP状态码：200 -- 数据

<a name="9k8kG"></a>
### 创建电影
请求方式：POST<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/movies<br />请求数据：
```json
{
	"name": "name",
  "duration": 123,
  "directors": "",
  "actors": "",
  "releaseDate": "",
  "categoryIds": [1,2],
  "status": "",
  "plot": "",
  "poster": "",
  "country": ""
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| name | String | 是 | 电影名称 |
| duration | int | 是 | 时长 |
| directors | String | 是 | 导演 |
| actors | String | 是 | 演员 |
| releaseDate | Date/String | 是 | 上映日期 |
| categoryIds | int[] | 是 | 类别id，多个类别 |
| status | int/String | 否 | 上映状态，默认未上映 |
| plot | String | 是 | 剧情 |
| poster | String | 是 | 电影海报链接 |
| country | String | 是 | 国家 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 创建失败

<a name="pa3Sh"></a>
### 修改电影
请求方式：PUT<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/movies/{id}<br />请求数据：
```json
{
	"name": "name",
  "duration": 120,
  "directors": "",
  "actors": "",
  "releaseDate": "",
  "categoryIds": [1],
  "status": "",
  "plot": "",
  "poster": "",
  "country": ""
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |
| name | String | 否 | 电影名称 |
| duration | int | 否 | 时长 |
| directors | String | 否 | 导演 |
| actors | String | 否 | 演员 |
| releaseDate | Date/String | 否 | 上映日期 |
| categoryIds | int[] | 否 | 类别id |
| status | int/String | 否 | 上映状态，默认未上映 |
| plot | String | 否 | 剧情 |
| poster | String | 否 | 电影海报链接 |
| country | String | 否 | 国家 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 更新失败<br />HTTP状态码：404 -- 资源未找到<br />**备注：该对象更新时并非全部字段更新，仅向后端传输需要更新的字段。例如：<br />PUT /movies/1**
```json
{
    "name": "乘风破浪",
    "directors": "韩寒",
    "actors": "邓超，彭于晏，赵丽颖，董子健，高华阳，张本煜，李荣浩"
}
```

<a name="mJVEW"></a>
### 删除电影
请求方式：DELETE<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/movies/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | String | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 删除失败<br />HTTP状态码：404 -- 资源未找到

<a name="BX6Pd"></a>
## 场次
<a name="EzW32"></a>
### 获取场次列表
请求方式：GET<br />请求地址：/scenes<br />请求参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| page | int | 否，默认1 | 页码 |
| size | int | 否，默认20 | 每页大小 |

HTTP状态码：200 -- 数据

<a name="oHQdZ"></a>
### 获取场次
请求方式：GET<br />请求地址：/scenes/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 数据<br />HTTP状态码：404 -- 资源未找到

<a name="e6QrF"></a>
### 获取电影下的场次
请求方式：GET<br />请求地址：/movies/{id}/scenes<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | 电影id |

-----返回结构<br />HTTP状态码：200 -- 数据<br />**备注：某个电影下没有场次或者有多个场次，没有场次也应该返回HTTP状态码200。**<br />**
<a name="FdJuL"></a>
### 创建场次
请求方式：POST<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/scenes<br />请求数据：
```json
{
	"movieId": "",
  "movieName": "",
  "price": 20,
  "seatNum": 166,
  "showtime": "12:10",
  "bookedSeat": ["A2", "B3"]
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| movieId | int | 是 | 电影id |
| movieName | String | 是 | 电影名称 |
| price | int | 是 | 该场次的价格 |
| seatNum | int | 否 | 座位数，默认数 |
| showtime | String/Date | 是 | 播放时间 |
| bookedSeat | String[] | 否 | 已预定的座位 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 创建失败

<a name="1WKyS"></a>
### 修改场次
请求方式：PUT<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/scenes/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | id |

请求数据：
```json
{
	"movieId": "",
  "movieName": "",
  "price": 20,
  "seatNum": 166,
  "showtime": "12:10",
  "bookedSeat": ["A2", "B3"]
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| movieId | int | 否 | 电影id |
| movieName | String | 否 | 电影名称 |
| price | int | 否 | 该场次的价格 |
| seatNum | int | 否 | 座位数，默认数 |
| showtime | String/Date | 否 | 播放时间 |
| bookedSeat | String[] | 否 | 已预定的座位 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 修改失败<br />HTTP状态码：404 -- 资源未找到

<a name="K1LOw"></a>
### 删除场次
请求方式：DELETE<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/scenes/{id}<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | String | 是 | id |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 删除失败<br />HTTP状态码：404 -- 资源未找到

<a name="SN1Df"></a>
## 评分
<a name="Jnm0L"></a>
### 获取某部电影的评分
请求方式：GET<br />请求地址：/movies/{id}/ranks<br />路径参数：

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| id | int | 是 | 电影id |

HTTP状态码：200 -- 数据<br />HTTP状态码：404 -- 资源未找到

<a name="dwUdM"></a>
### 创建评分
请求方式：POST<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/ranks<br />请求数据：
```json
{
  "userId": 7,
  "movieId": 2,
  "score": 1
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| movieId | int | 是 | 电影id |
| userId | int | 是 | 用户id |
| score | int | 是 | 评分 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 创建失败<br />**备注**：评分的范围在1-5之间，整数。

<a name="l3s3M"></a>
### 更新评分
请求方式：PUT<br />请求头：Content-Type: application/json;charset=utf-8<br />请求地址：/movies/{id}<br />请求数据：
```json
{
  "userId": 7,
  "movieId": 2,
  "score": 1
}
```

| 参数值 | 参数类型 | 是否必须 | 说明 |
| --- | --- | --- | --- |
| movieId | int | 是 | 电影id |
| userId | int | 是 | 用户id |
| score | int | 是 | 评分 |

-----返回结构<br />HTTP状态码：200 -- 成功<br />HTTP状态码：400 -- 更新失败<br />HTTP状态码：404 -- 资源未找到



