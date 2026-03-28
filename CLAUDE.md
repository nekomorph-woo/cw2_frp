# CLAUDE.md

本文件为 Claude Code (claude.ai/code) 在此代码仓库中工作时提供指导。

## 项目概述

这是一个使用 Kotlin 和 Jetpack Compose 构建 UI 的 IntelliJ Platform 插件项目。该插件使用 Jewel（JetBrains Compose UI 库）来构建工具窗口界面。

## 构建命令

```bash
# 构建插件
./gradlew buildPlugin

# 运行带插件的 IDE（用于开发/测试）
./gradlew runIde

# 运行测试
./gradlew test

# 验证插件兼容性
./gradlew verifyPlugin

# 发布插件到 JetBrains Marketplace
./gradlew publishPlugin
```

## 架构

- **Package**: `cw.chaos.cw_2frp`
- **Target IDE**: IntelliJ IDEA 2025.2.4 (since-build: 252.25557)
- **JVM**: Java 21
- **Kotlin**: 2.1.20 with Compose compiler plugin

### 目录结构

```
.
├── .run/                   Predefined Run/Debug Configurations
├── build/                  Output build directory
├── gradle
│   └── wrapper/            Gradle Wrapper
├── src                     Plugin sources
│   ├── main
│   │   ├── kotlin/         Kotlin production sources
│   │   └── resources/      Resources - plugin.xml, icons, messages
├── .gitignore              Git ignoring rules
├── build.gradle.kts        Gradle build configuration
├── gradle.properties       Gradle configuration properties
├── gradlew                 *nix Gradle Wrapper script
├── gradlew.bat             Windows Gradle Wrapper script
├── README.md               README
└── settings.gradle.kts     Gradle project settings
```

### 依赖

- `com.intellij.modules.compose` - Compose UI support
- `org.jetbrains.kotlin` - Kotlin plugin dependency
- Jewel UI components (bundled with IntelliJ Platform)

## UI 开发

该插件使用 Jewel (`org.jetbrains.jewel`) 在 IntelliJ 中构建基于 Compose 的 UI 组件：

- 使用 `toolWindow.addComposeTab()` 向工具窗口添加 Compose 内容
- 可用的 Jewel 组件：`Text`、`OutlinedButton`、`TextField` 等
- 布局使用标准的 Compose modifiers 和 arrangements

## 插件扩展点

工具窗口在 `plugin.xml` 中注册：
```xml
<extensions defaultExtensionNs="com.intellij">
    <toolWindow id="MyToolWindow" factoryClass="cw.chaos.cw_2frp.MyToolWindowFactory"
                icon="AllIcons.Toolwindows.ToolWindowPalette"/>
</extensions>
```

## 日志

通过 `runIde` 运行时，日志位于：
`build/idea-sandbox/system/log/idea.log`
