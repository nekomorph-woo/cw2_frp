# Java 环境配置

本项目使用 IDEA 自动下载的 Java 21 环境。

## Java 路径

```
JAVA_HOME=/Users/chaooswoo/Library/Java/JavaVirtualMachines/ms-21.0.10/Contents/Home
```

## 使用方式

运行 Gradle 命令时，需要设置 JAVA_HOME：

```bash
export JAVA_HOME=/Users/chaooswoo/Library/Java/JavaVirtualMachines/ms-21.0.10/Contents/Home
./gradlew <task>
```

或单行执行：

```bash
JAVA_HOME=/Users/chaooswoo/Library/Java/JavaVirtualMachines/ms-21.0.10/Contents/Home ./gradlew <task>
```

## 版本信息

- OpenJDK 21.0.10 LTS
- Microsoft-13106411 (build 21.0.10+7-LTS)
