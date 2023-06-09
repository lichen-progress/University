
```
ShareService
├─ .gitignore
├─ .mvn
│  └─ wrapper
│     ├─ maven-wrapper.jar
│     └─ maven-wrapper.properties
├─ mvnw
├─ mvnw.cmd
├─ pom.xml
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ example
   │  │        └─ shareservice
   │  │           ├─ config
   │  │           │  ├─ Swagger2Config.java
   │  │           │  └─ WebConfig.java
   │  │           ├─ controller
   │  │           │  ├─ FileController.java
   │  │           │  ├─ HomeController.java
   │  │           │  └─ UserController.java
   │  │           ├─ entity
   │  │           │  ├─ Comment.java
   │  │           │  ├─ Resource.java
   │  │           │  └─ User.java
   │  │           ├─ interceptor
   │  │           │  └─ LoginInterceptor.java
   │  │           ├─ mapper
   │  │           │  ├─ CommentMapper.java
   │  │           │  ├─ ResourceMapper.java
   │  │           │  ├─ TagMapper.java
   │  │           │  └─ UserMapper.java
   │  │           └─ ShareServiceApplication.java
   │  └─ resources
   │     ├─ application.properties
   │     ├─ static
   │     │  └─ 07.jpg
   │     └─ templates
   └─ test
      └─ java
         └─ com
            └─ example
               └─ shareservice
                  └─ ShareServiceApplicationTests.java

```