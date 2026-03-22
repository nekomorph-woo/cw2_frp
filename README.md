# IntelliJ Platform Plugin Template

[![Twitter Follow](https://img.shields.io/badge/follow-%40JBPlatform-1DA1F2?logo=twitter)](https://twitter.com/JBPlatform)
[![Developers Forum](https://img.shields.io/badge/JetBrains%20Platform-Join-blue)][jb:forum]

## 插件模板结构

生成的项目包含以下内容结构：

```
.
├── .run/                   预定义的 Run/Debug 配置
├── build/                  输出构建目录
├── gradle
│   ├── wrapper/            Gradle Wrapper
├── src                     插件源代码
│   ├── main
│   │   ├── kotlin/         Kotlin 生产源代码
│   │   └── resources/      资源文件 - plugin.xml、图标、消息
├── .gitignore              Git 忽略规则
├── build.gradle.kts        Gradle 构建配置
├── gradle.properties       Gradle 配置属性
├── gradlew                 *nix Gradle Wrapper 脚本
├── gradlew.bat             Windows Gradle Wrapper 脚本
├── README.md               README
└── settings.gradle.kts     Gradle 项目设置
```

除了配置文件外，最重要的部分是 `src` 目录，其中包含我们的实现代码以及插件的清单文件 —— [plugin.xml][file:plugin.xml]。

> [!NOTE]
> 如果要在插件中使用 Java，请创建 `/src/main/java` 目录。

## 插件配置文件

插件配置文件是位于 `src/main/resources/META-INF` 目录下的 [plugin.xml][file:plugin.xml] 文件。
它提供了关于插件的常规信息、依赖项、扩展点和监听器。

您可以在我们文档的 [Plugin Configuration File][docs:plugin.xml] 章节中了解更多关于此文件的信息。

如果您还不太确定这是关于什么的，请阅读我们的介绍：
[What is the IntelliJ Platform?][docs:intro]

## 预定义的 Run/Debug 配置

在默认的项目结构中，提供了一个 `.run` 目录，其中包含预定义的 *Run/Debug 配置*，这些配置暴露了相应的 Gradle 任务：

| 配置名称           | 描述                                                                                                                                                                         |
|--------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Run Plugin         | 运行 [`:runIde`][gh:intellij-platform-gradle-plugin-runIde] IntelliJ Platform Gradle Plugin 任务。使用 *Debug* 图标进行插件调试。                                        |
| Run Tests          | 运行 [`:test`][gradle:lifecycle-tasks] Gradle 任务。                                                                                                                                 |
| Run Verifications  | 运行 [`:verifyPlugin`][gh:intellij-platform-gradle-plugin-verifyPlugin] IntelliJ Platform Gradle Plugin 任务，以检查插件与指定 IntelliJ IDE 的兼容性。 |

> [!NOTE]
> 您可以在 `idea.log` 标签页中找到运行任务的日志。

## 发布插件

> [!TIP]
> 请务必遵循 [Publishing a Plugin][docs:publishing] 中列出的所有指南，以完成所有推荐和必需的步骤。

将插件发布到 [JetBrains Marketplace](https://plugins.jetbrains.com) 是一个简单的操作，使用的是
[intellij-platform-gradle-plugin][gh:intellij-platform-gradle-plugin-docs] 提供的 `publishPlugin` Gradle 任务。

您也可以通过 UI 手动将插件上传到 [JetBrains Plugin Repository](https://plugins.jetbrains.com/plugin/upload)。

## 有用的链接

- [IntelliJ Platform SDK Plugin SDK][docs]
- [IntelliJ Platform Gradle Plugin Documentation][gh:intellij-platform-gradle-plugin-docs]
- [IntelliJ Platform Explorer][jb:ipe]
- [JetBrains Marketplace Quality Guidelines][jb:quality-guidelines]
- [IntelliJ Platform UI Guidelines][jb:ui-guidelines]
- [JetBrains Marketplace Paid Plugins][jb:paid-plugins]
- [IntelliJ SDK Code Samples][gh:code-samples]

[docs]: https://plugins.jetbrains.com/docs/intellij

[docs:intro]: https://plugins.jetbrains.com/docs/intellij/intellij-platform.html?from=IJPluginTemplate

[docs:plugin.xml]: https://plugins.jetbrains.com/docs/intellij/plugin-configuration-file.html?from=IJPluginTemplate

[docs:publishing]: https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate

[file:plugin.xml]: ./src/main/resources/META-INF/plugin.xml

[gh:code-samples]: https://github.com/JetBrains/intellij-sdk-code-samples

[gh:intellij-platform-gradle-plugin]: https://github.com/JetBrains/intellij-platform-gradle-plugin

[gh:intellij-platform-gradle-plugin-docs]: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html

[gh:intellij-platform-gradle-plugin-runIde]: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#runIde

[gh:intellij-platform-gradle-plugin-verifyPlugin]: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-tasks.html#verifyPlugin

[gradle:lifecycle-tasks]: https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks

[jb:github]: https://github.com/JetBrains/.github/blob/main/profile/README.md

[jb:forum]: https://platform.jetbrains.com/

[jb:quality-guidelines]: https://plugins.jetbrains.com/docs/marketplace/quality-guidelines.html

[jb:paid-plugins]: https://plugins.jetbrains.com/docs/marketplace/paid-plugins-marketplace.html

[jb:quality-guidelines]: https://plugins.jetbrains.com/docs/marketplace/quality-guidelines.html

[jb:ipe]: https://jb.gg/ipe

[jb:ui-guidelines]: https://jetbrains.github.io/ui