# DBsSA: Digital British-style Student Apartments

![](https://img.shields.io/badge/language-Java-orange.svg)
![](https://img.shields.io/badge/backend_frame-Spring_Boot-6db33f.svg)
![](https://img.shields.io/badge/ORM-MyBatis-red.svg)
![](https://img.shields.io/badge/deploy-Docker-blue.svg)
![](https://img.shields.io/badge/license-Apache_2.0-green.svg)

---

<font size="5"><strong>目录<strong></font>

- [DBsSA 项目介绍 (Project Introduction)](#dbssa-项目介绍-project-introduction)
- [DBsSA 相关项目传送门 (Portal of DBsSA-related Projects)](#dbssa-相关项目传送门-portal-of-dbssa-related-projects)
- [功能规划 (Functional Planning)](#功能规划-functional-planning)
    - [🏢 企业运营端](#-企业运营端)
    - [🏠 公寓运营端](#-公寓运营端)
    - [👨🏻‍🎓 公寓住户端](#-公寓住户端)
    - [🧑🏻‍💻 公寓预订系统](#-公寓预订系统)
    - [🎬 公寓影院](#-公寓影院)
    - [🏬 公寓二手交易平台](#-公寓二手交易平台)
- [系统架构设计](#系统架构设计)
- [接口设计](#接口设计)
    - [接口文档](#接口文档)
    - [接口错误码](#接口错误码)
- [Mock的服务](#mock的服务)
- [项目指引](#项目指引)

## DBsSA 项目介绍 (Project Introduction)

该项目旨在将英式学生公寓的日常繁杂的手工流程进行梳理和抽象，映射为数字化信息流程。 项目基于SpringBoot +
MyBatis框架，结合大数据技术、人工智能算法、区块链服务搭建而成，进一步提供高效化、合规化、智能化的学生公寓数字化服务。

The project aims to sort out and abstract the daily complicated manual processes of British-style student apartments,
and map them into digital information processes. The project is based on the SpringBoot + MyBatis framework, combined
with Big Data Technology, Artificial Intelligence Algorithms, and Blockchain Services, to further provide efficient,
compliant, and intelligent digital services for student apartments.

## DBsSA 相关项目传送门 (Portal of DBsSA-related Projects)

| 项目 (Project) | 编程语言 (Language) | 传送门 (Link) |
| --- | --- | --- |
| Web前端 (Web Frontend) | Vue.js + TypeScript | [~~敬请期待 (Coming Soon)~~]() |
| 移动端Android App (Mobile Android App) | Kotlin | [~~敬请期待 (Coming Soon)~~]() |
| 区块链服务 (Blockchain Service) | Golang | [~~敬请期待 (Coming Soon)~~]() |
| 推荐算法 (Recommendation Algorithm) | Java、Python、C++ | [~~敬请期待 (Coming Soon)~~]() |
| 即时通讯组件 (Instant Messaging Component) | C++、Java、Python | [~~敬请期待 (Coming Soon)~~]() |
| 影院终端桌面版 (Cinema Terminal Desktop Version) | C++ | [~~敬请期待 (Coming Soon)~~]() |
| Mock服务 (Mock Service) | Python | [~~敬请期待 (Coming Soon)~~]() |

## 功能规划 (Functional Planning)

### 🏢 企业运营端

- [ ] 企业管理
    - [x] 企业人员管理
        - [ ] 企业人员公寓分配管理
- [ ] 公寓管理
    - [x] 公寓楼管理
        - [ ] 房型管理
        - [ ] 房间管理
            - [ ] 批量数据处理，支持导入导出（ CSV / Excel / JSON ）
        - [ ] 公寓楼组织架构管理
        - [ ] 公寓楼运营权限管理
        - [ ] 公寓人员权限管理
            - [ ] 以组织架构为单位的批量权限赋予
            - [ ] 单人权限赋予（最高优先级）
- [ ] 公寓影院资源管理
    - [ ] 影片资源管理
- [ ] 数据统计

### 🏠 公寓运营端

- [ ] 公寓信息查询
- [ ] 公寓住户管理
- [ ] 公寓资产管理
- [ ] 公寓入住退租管理
- [ ] 公寓报修管理
- [ ] 公寓合同管理
    - [ ] 发起合同签署
    - [ ] 合同续约
    - [ ] 合同作废
    - [ ] 合同转让
    - [ ] 合同查询
- [ ] 门禁卡管理
- [ ] 网络账户管理
- [ ] 邮件通讯管理

### 👨🏻‍🎓 公寓住户端

- [ ] 登陆
- [ ] 扫一扫
- [ ] 信息查询
    - [ ] 个人信息
    - [ ] 居住信息
    - [ ] 公寓楼信息/房间信息
    - [ ] 合同信息
- [ ] 电子门禁卡
- [ ] 在线报修
    - [ ] 报修申请
    - [ ] 报修查询
- [ ] 账单管理
- [ ] 账单支付
- [ ] 公寓小圈子

### 🧑🏻‍💻 公寓预订系统

- [ ] 分期计算器
- [ ] 预订房间
- [ ] 预订追踪
- [ ] 邮件往来

### 🎬 公寓影院

- [ ] 影院终端
    - [ ] 用户扫码登陆
    - [ ] 影片库
    - [ ] 影片播放器
    - [ ] 观影记录
    - [ ] 影片点评（顶、踩、评论）
    - [ ] 电影推荐

### 🏬 公寓二手交易平台

- [ ] 登陆
    - [ ] 扫码登陆
    - [ ] 账户登陆
    - [ ] 免登陆
- [ ] 二手商品发布
- [ ] 二手商品交易
- [ ] 物流跟踪
- [ ] 买卖家交流

## 系统架构设计

敬请期待

## 接口设计

### 接口文档

[接口文档传送门](docs/api/README.md)

### 接口错误码

[接口错误码文档](docs/api_error_code/README.md)

## Mock的服务

* 物流系统（参考顺丰快递查询接入流程，https://open.sf-express.com/Api?category=1&apiClassify=1）
* 支付系统（参考微信支付 & 支付宝接入流程）

## 项目指引

* 数据库表更新，需要使用MBG重新逆向工程，命令是

```bash
mvn mybatis-generator:generate
```