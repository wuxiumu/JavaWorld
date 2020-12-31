**Scrcpy** 可以视为开源免费版的 [Vysor](https://www.iplaysoft.com/vysor.html) 替代品，可以将安卓手机的画面[投屏](https://www.iplaysoft.com/tag/串流)到电脑桌面显示上并进行操控。简单地说，就是可以**让你在电脑上控制手机**！它支持鼠标控制、键盘输入、电脑[剪切板](https://www.iplaysoft.com/tag/剪贴板)复制粘贴、拖放文件[传输](https://www.iplaysoft.com/tag/共享)到手机、以及拖放 [APK](https://www.iplaysoft.com/tag/apk) 文件进行安装。

![Scrcpy](https://img.iplaysoft.com/wp-content/uploads/2019/scrcpy/scrcpy.jpg!0x0.webp)

Scrcpy 实际的投屏效果非常理想，画面清晰流畅，基本无明显延迟，相比 Vysor 要付费后才能设置高码率，[Scrcpy](https://www.iplaysoft.com/scrcpy.html) 可以自定义[视频](https://www.iplaysoft.com/tag/视频)码率这点显得十分良心。软件支持自动横屏，操作很灵敏，实用性非常的高。

![Scrcpy](https://img.iplaysoft.com/wp-content/uploads/2019/scrcpy/scrcpy_screenshot.jpg!0x0.webp)

你可以方便地利用 **Scrcpy** 来测试 APP 应用、玩游戏、高效完成一些需要在手机上进行的复杂[工作](https://www.iplaysoft.com/tag/办公)、更高效地[办公](https://www.iplaysoft.com/tag/办公)；也能更方便地进行 Android 屏幕[录像](https://www.iplaysoft.com/tag/录像)、[截屏](https://www.iplaysoft.com/tag/截图)；甚至还能方便你上班时[摸鱼](https://www.iplaysoft.com/thief-book.html)划水。应用场景非常多，无论是开发者还是普通个人用户都相当的实用。如果经常有电脑上操控手机的需求，那么 Scrcpy 可谓是妥妥的[神器](https://www.iplaysoft.com/tag/神器)！

### 电脑控制手机软件 Scrcpy 视频演示：

点击开始播放视频



Scrcpy 是一款命令行工具，没有图形界面，但这并不妨碍它成为一款出色好用的开源软件！其实它的使用也并不复杂。

使用 Scrcpy 你**无需 ROOT 手机**，也不需在手机上安装 APP，只需在系统设置里启用“USB调试”( adb 调试) 即可。连接电脑的方式可选 [USB](https://www.iplaysoft.com/tag/usb) 数据线连接或 ADB 无线 [WiFi](https://www.iplaysoft.com/tag/wifi) 连接。下面我们给大家提供一个 Scrcpy 的简单使用教程。

### Scrcpy 使用教程：

#### 准备工作：

1. 准备好 USB 数据线，安卓系统版本要求 5.0 以上
2. Scrcpy 需要使用 adb 驱动进行与电脑之间通讯，Windows 版的安装包里似乎已经包含了 adb。你也可以手动从[下载这个 ADB 命令行工具](https://www.iplaysoft.com/p/adb)进行安装。
3. 需要在手机端的系统设置里开启「开发者选项」及「USB 调试」选项。不同的手机开启方法不尽相同，找不到选项的话可以自行去搜索一下。

![开启 USB 调试](https://img.iplaysoft.com/wp-content/uploads/2019/scrcpy/usb_debug.jpg!0x0.webp)

#### Windows 下载安装：

Windows 用户直接下载并安装，连接好数据线后，电脑上执行 scrcpy.exe 即可启动软件。首次连接时，手机上会问你是否允许它对设备进行调试，按下确认同意即可。

![允许调试](https://img.iplaysoft.com/wp-content/uploads/2019/scrcpy/allow_debug.png!0x0.webp)

#### macOS 下载安装：

[Mac](https://www.iplaysoft.com/go/mac) 用户需要使用 **HomeBrew** 命令进行安装。其实 HomeBrew 的功能很实用，它可以帮助你非常简单地一键安装/卸载各种软件，包括 Scrcpy。

1. 安装 homebrew：

    

   通过命令行 (Terminal) 执行 ，如已安装可跳过

   ```
   /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
   ```

2. 安装 Scrcpy： 

   (如果网络太慢，可以考虑

   更换 Homebrew 国内源

   或使用代理)

   ```
   brew install scrcpy
   ```

3. 安装 ADB：

   如果你没有安装

    

   ADB 命令行工具

   ，那么也可以用 brew 来安装

   ```
   brew cask install android-platform-tools
   ```

4. 使用 USB 数据线连接手机后，执行 `scrcpy` 命令即可启动软件。首次连接会在手机上问你是否允许它对设备进行调试，按下确认同意即可。

5. 如果你有多台手机连接到电脑，可以执行 `adb devices` 查看每一台设备对应的ID，然后执行 `scrcpy -s 设备ID` 来连接使用指定的设备。

#### Linux 编译安装：

Linux 用户可以[参考官网的说明](https://github.com/Genymobile/scrcpy/blob/master/BUILD.md)自己编译安装。

### Scrcpy 一些实用的命令参数：

这些参数可以多个自由组合使用，注意区分大小写。

| Scrcpy 的命令参数           |                                                              |
| --------------------------- | ------------------------------------------------------------ |
| **关闭手机屏幕**            | `scrcpy -S`                                                  |
| **限制画面分辨率**          | `scrcpy -m 1024` (比如限制为 1024)                           |
| **修改视频码率**            | `scrcpy -b 4M` (默认 8Mbps，改成 4Mbps)                      |
| **裁剪画面**                | `scrcpy -c 1224:1440:0:0` 表示分辨率 1224x1440 并且偏移坐标为 (0,0) |
| **多设备切换**              | `scrcpy -s 设备ID` (使用 `adb devices` 命令查看设备ID)       |
| **窗口置顶**                | `scrcpy -T`                                                  |
| **显示触摸点击**            | `scrcpy -t` 在演示或录制教程时，可在画面上对应显示出点击动作 |
| **全屏显示**                | `scrcpy -f`                                                  |
| **文件传输默认路径**        | `scrcpy --push-target /你的/目录` 将文件拖放到 scrcpy 可以传输文件，此命令指定默认保存目录 |
| **只读模式(仅显示不控制)**  | `scrcpy -n`                                                  |
| **屏幕录像**                | `scrcpy -r 视频文件名.mp4` 或 `.mkv`                         |
| **屏幕录像 (禁用电脑显示)** | `scrcpy -Nr 文件名.mkv`                                      |
| **设置窗口标题**            | `scrcpy --window-title '异次元好棒！'`                       |
| **同步传输声音**            | 可借助 [USBaudio](https://github.com/rom1v/usbaudio) 这个开源项目实现，但仅支持 [Linux](https://www.iplaysoft.com/os/linux-platform) 系统 |

### Scrcpy 使用与快捷键：

启动之后，你就可以在电脑桌面上看到 Scrcpy 的投屏窗口和手机画面了，你可以直接用鼠标进行操作，它同时也有很多键盘快捷键可以使用。

![scrcpy](https://img.iplaysoft.com/wp-content/uploads/2019/scrcpy/scrcpy_android.jpg!0x0.webp)

| Scrcpy 快捷键列表              |                            |
| ------------------------------ | -------------------------- |
| 切换全屏模式                   | `Ctrl`+`F`                 |
| 将窗口调整为1：1（完美像素）   | `Ctrl`+`G`                 |
| 调整窗口大小以删除黑色边框     | `Ctrl`+`X` \| 双击黑色背景 |
| 设备 `HOME` 键                 | `Ctrl`+`H` \| 鼠标中键     |
| 设备 `BACK` 键                 | `Ctrl`+`B` \| 鼠标右键     |
| 设备 `任务管理` 键 (切换APP)   | `Ctrl`+`S`                 |
| 设备 `菜单` 键                 | `Ctrl`+`M`                 |
| 设备`音量+`键                  | `Ctrl`+`↑`                 |
| 设备`音量-`键                  | `Ctrl`+`↓`                 |
| 设备`电源键`                   | `Ctrl`+`P`                 |
| 点亮手机屏幕                   | 鼠标右键                   |
| 复制内容到设备                 | `Ctrl`+`V`                 |
| 启用/禁用 FPS 计数器（stdout） | `Ctrl`+`i`                 |
| 安装APK                        | 将 apk 文件拖入投屏        |
| 传输文件到设备                 | 将文件拖入投屏（非apk）    |

注：在 macOS 平台上，请使用 `cmd` 代替 `Ctrl`。

### 屏幕录像：

如有需要，你也可以通过命令对连接好的安卓手机进行[录屏](https://www.iplaysoft.com/tag/录像)，并将视频保存为 .mp4 格式。

- **投屏并录屏：**`scrcpy -r file.mp4`
- **不投屏只录屏：**`scrcpy -Nr file.mp4`

#### scrcpy 录屏效果：

![Scrcpy 屏幕录像](https://img-dp.iplaysoft.com/dispatch/1ad2223b738a434e22f9f8bb8bcd4a62.gif)

Scrcpy 屏幕录像效果

这是实际录像的效果，由于转换成 [GIF](https://www.iplaysoft.com/tag/gif) 图片压缩得比较厉害，这里看起来卡顿模糊，但实际上录像非常清晰流畅的，用来做演示、[教程](https://www.iplaysoft.com/tag/教程)、直播什么的完全没有问题。

### 使用 WIFi 无线连接：

Scrcpy 使用 adb 与 Android 设备通讯，而 adb 本身是支持无线连接的。因此除了 USB 数据线之外，我们也能无线使用。前提是需要保证手机和电脑处于同一[局域网](https://www.iplaysoft.com/tag/局域网) (连接到相同的 [WiFi](https://www.iplaysoft.com/tag/wifi) 路由器)，步骤如下：

1. 查询设备当前的 IP 地址 (设置 →关于手机→状态)
2. 启用 adb TCP/IP 连接，执行命令：`adb tcpip 5555`，其中 5555 为端口号
3. 拔掉你的数据线
4. 通过 WiFi 进行连接，执行命令：`adb connect 设备IP地址:5555`
5. 重新启动 scrcpy 即可
6. 如果 WiFi 较慢，可以调整码率：`scrcpy -b 3M -m 800`，意思是限制 3 Mbps，画面分辨率限制 800，数值可以随意调整。
7. 如需切换回 USB 模式，执行：`adb usb`

### 总结：

个人感觉 **Scrcpy** 用来[办公](https://www.iplaysoft.com/tag/办公)真的很方便，可以在电脑前轻松处理手机端的事情，对于没有电脑端的 App，或必须用手机来操作时，Scrcpy 真的能让你[效率](https://www.iplaysoft.com/tag/效率)猛增！绝对是人手必备的[利器](https://www.iplaysoft.com/tag/神器)。

再加上 Scrcpy 完全免费开源，支持跨平台，支持录屏，而且是独立的程序。 而 [Vysor](https://www.iplaysoft.com/vysor.html) 则是基于 [Chrome 浏览器](https://www.iplaysoft.com/google-chrome.html)的一款扩展，并非独立应用，且高级功能需要付费。相比之下，免费的 Scrcpy 显得更加良心，也更加适合大众使用，非常值得推荐。