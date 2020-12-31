https://github.com/Genymobile/scrcpy

Scrcpy 安装

```
snap install scrcpy
```

adb服务安装

```
sudo apt-get install android-tools-adb
```

adb配置

查看手机的USB识别号

手机通过USB连接电脑

```
lsusb
```

![img](https://img.jbzj.com/file_images/article/201910/2019101610373631.png)

找打自己手机的识别号, 我是04e8:6860

创建设备文件

下面所有的`04e8`改成自己的识别号, `android.rules`文件名可自定义

```
mkdir ~/.android``echo 0x04e8 > ~/.android/adb_usb.ini``sudo touch /etc/udev/rules.d/android.rules``sudo gedit /etc/udev/rules.d/android.rules
```

在文件中输入:

```
SUBSYSTEM=="usb", SYSFS{idVendor}=="04e8", MODE="0666"
```

保存后修改文件权限

```
sudo chmod 777 /etc/udev/rules.d/android.rules
```

启动adb服务

```
service udev restart``adb start-servert``adb devices
```

![img](https://img.jbzj.com/file_images/article/201910/2019101610373632.png)

有设备就说明成功了, 如果没有看看自己手机的开发者模式有没有打开, 不同手机的开发者模式位置不同, 自行百度

**使用scrcpy**

命令行输入

```
scrcpy
```

就会弹出界面了


![img](https://img.jbzj.com/file_images/article/201910/2019101610373633.jpg)

scrcpy使用方法鼠标左键点击、滑动、长按鼠标中键回到主屏幕鼠标右键返回复制文本电脑到手机: 电脑上复制后, 在手机投屏界面按`Ctrl+Shift+V`复制到手机剪切板, 然后手机中粘贴手机到电脑: 手机上复制到剪切板中, 在投屏界面按下`Ctrl+C`键，再到电脑正常上粘贴传输文件: 直接在文件管理器复制粘贴


![img](https://img.jbzj.com/file_images/article/201910/2019101610373634.png)



终于可以Ubuntu上用QQ和微信啦，不用频繁在键盘和手机间切换了