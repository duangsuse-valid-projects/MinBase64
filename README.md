# MinBase64
最小化的base64编解码器(大雾)，使用android.util.Base64完成底层操作(将来会加入基于Rust语言编解码器支持)<br>
许可证:__GNU GENERIC PUBLIC LICENCE version 3 (GPLv3)__我不知道这种应用会不会有人非法套用:smirk:这么烂<br>
>注:本应用使用AIDE开发~主要是因为没有特殊需要，而且duangsuse的电脑炸 。本suse表示¯\_(ツ)_/¯


##安装
直接使用`Android`提供的图形apk安装器即可
##使用
按照应用内提示即可:pill:<br>
##项目构建状态
CI服务由__flow.ci&老T__提供:heart:
Flow.ci|Travis.ci

http://dashboard.flow.ci/projects/5898a0faef2cb06eff25626d/jobs

[![Build Status](https://travis-ci.org/pigfromChina/MinBase64.svg?branch=master)](https://travis-ci.org/pigfromChina/MinBase64)

底层|状态
 ---|---
 rust编解码器集装箱 |*目前不支持*
 android.util.Base64|支持
 强行推广 :sparkles:
 ![胖的成图标包](http://image.coolapk.com/apk_logo/2017/0203/PDCE59BBEE6A087E58C85512x512-28429-for-110125-o_1b7vps9jljmd8gouk31hpv1g6iq-uid-531994.png)
 
# 最后:TODO

- [x] 与github同步进度
 - [ ] 完成开发
 - [ ] 发布酷安
 - [ ] 增加基于rust语言编译二进制crate编解码支持