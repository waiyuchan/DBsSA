# DBsSA 接口文档 （DBsSA API Document）

---

<font size="5"><strong>目录<strong></font>

  - [公寓模块（Apartment Module）](#公寓模块apartment-module)
    - [公寓相关接口 （Apartment Related Interfaces）](#公寓相关接口-apartment-related-interfaces)
      - [创建公寓楼 （Create Apartment）](#创建公寓楼-create-apartment)
      - [查询公寓楼信息（Query Apartment Information）](#查询公寓楼信息query-apartment-information)
      - [查询公寓楼列表（Query Apartments）](#查询公寓楼列表query-apartments)
    - [预订系统相关接口（Reservation Related Interfaces）](#预订系统相关接口reservation-related-interfaces)
      - [查询可预订的公寓列表 (Query Available Apartments)](#查询可预订的公寓列表-query-available-apartments)
      - [创建预订订单（Create Reservation Order）](#创建预订订单create-reservation-order)

## 公寓模块（Apartment Module）

### 公寓相关接口 （Apartment Related Interfaces）

#### 创建公寓楼 （Create Apartment）

* **接口 (Interface)：** `/apartment`
* **请求方法 (Request Method)：** `POST`
* **请求内容 (Request Body)：**

```json
{
  "apartmentName": "Atlas",
  "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
  "officialPhone": "+44 204 537 9191",
  "floorNumber": 37,
  "numberOfRooms": 400,
  "numberOfBedrooms": 535,
  "numberOfBathrooms": 570,
  "numberOfPublicRooms": 26,
  "floorSpace": 800,
  "maximumRent": "670",
  "createDate": "2021-04-01",
  "startDate": "2022-01-01"
}
```

* **响应内容 (Response Body)：**

```json
{
  "errorCode": 0,
  "errorMsg": "success",
  "data": {
    "apartmentId": 1
  }
}
```

#### 查询公寓楼信息（Query Apartment Information）

* **接口 (Interface)：** `/apartment/{apartmentId}`
* **请求方法 (Request Method)：** `GET`
* **请求内容 (Request Body)：**
* **响应内容 (Response Body)：**

```json
{
  "id": 1,
  "apartmentName": "Atlas",
  "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
  "officialPhone": "+44 204 537 9191",
  "floorNumber": 37,
  "numberOfRooms": 400,
  "numberOfBedrooms": 535,
  "numberOfBathrooms": 570,
  "numberOfPublicRooms": 26,
  "floorSpace": 800,
  "maximumRent": "670",
  "createDate": "2021-04-01",
  "startDate": "2022-01-01"
}
```

#### 查询公寓楼列表（Query Apartments）

* **接口 (Interface)：** `/apartments`
* **请求方法 (Request Method)：** `GET`
* **请求内容 (Request Body)：**
* **响应内容 (Response Body)：**

```json
[
  {
    "id": 1,
    "apartmentName": "Atlas",
    "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
    "officialPhone": "+44 204 537 9191",
    "floorNumber": 37,
    "numberOfRooms": 400,
    "numberOfBedrooms": 535,
    "numberOfBathrooms": 570,
    "numberOfPublicRooms": 26,
    "floorSpace": 800,
    "maximumRent": "670",
    "createDate": "2021-04-01",
    "startDate": "2022-01-01"
  },
  {
    "id": 2,
    "apartmentName": "Vega",
    "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
    "officialPhone": "+44 204 537 9191",
    "floorNumber": 37,
    "numberOfRooms": 400,
    "numberOfBedrooms": 535,
    "numberOfBathrooms": 570,
    "numberOfPublicRooms": 26,
    "floorSpace": 800,
    "maximumRent": "670",
    "createDate": "2021-04-01",
    "startDate": "2022-01-01"
  }
]
```

### 预订系统相关接口（Reservation Related Interfaces）

#### 查询可预订的公寓列表 (Query Available Apartments)

* **接口 (Interface)：** `/reservation/apartments`
* **请求方法 (Request Method)：** `GET`
* **请求内容 (Request Body)：**
* **响应内容 (Response Body)：**

```json
[
  {
    "id": 1,
    "apartmentName": "Atlas",
    "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
    "officialPhone": "+44 204 537 9191",
    "floorNumber": 37,
    "numberOfRooms": 400,
    "numberOfBedrooms": 535,
    "numberOfBathrooms": 570,
    "numberOfPublicRooms": 26,
    "floorSpace": 800,
    "maximumRent": "670",
    "createDate": "2021-04-01",
    "startDate": "2022-01-01"
  },
  {
    "id": 2,
    "apartmentName": "Vega",
    "address": "6 Miles Street, Vauxhall, London SW8 1RZ",
    "officialPhone": "+44 204 537 9191",
    "floorNumber": 37,
    "numberOfRooms": 400,
    "numberOfBedrooms": 535,
    "numberOfBathrooms": 570,
    "numberOfPublicRooms": 26,
    "floorSpace": 800,
    "maximumRent": "670",
    "createDate": "2021-04-01",
    "startDate": "2022-01-01"
  }
]
```

#### 创建预订订单（Create Reservation Order）