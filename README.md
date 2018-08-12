# Spins
Spins can create wheel pickers. First of all WheelPicker is developed by [AigeStudio](https://github.com/AigeStudio),
you can get more information about that on [this](https://github.com/AigeStudio/WheelPicker).(Thanks AigeStudio about that)

## Prerequisites
First, dependency must be added to build.gradle file.
```groovy
implementation 'nurisezgin.com.spins:spins:1.0.0'
```

## How To Use
* Add WheelListView as view to layout xml file or you can use programmatically.
```xml
    <nurisezgin.com.spins.core.WheelHorizontalListView xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/date_wheel_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
* An option on that you can set a different height value with attribute of "app:content_height" and give a
custom toolbar layout. Toolbar means, that view over wheel pickers like a title bar.
* Set an adapter to list view.
```java
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(customAdapter);
    }
```
* You can customize wheel pickers onBindWheelPicker method that inside of WheelListAdapter.
```java
@Override
    public void onBindWheelPicker(WheelPicker picker, int sectionPosition) {
        picker.setAtmospheric(true);
        picker.setCyclic(true);
        picker.setCurved(true);
    }
```

## DatePicker
* Spins has custom date pickers. That is created with wheelpicker views. You can
use different ways the easiest way is below. DatePicker never get any callback, on some stop
cases very dangerous and process will be killed by OS that's why you have to implement callback
methods to activity or current fragment. (Check DatePicker newInstance methods.)

```java
    DatePicker.newInstance(this).show(getSupportFragmentManager(), "TAG");
```

or with config

```java
    DatePicker.newInstance(this, customConfigs).show(getSupportFragmentManager(), "TAG");
```

## Authors
* **Nuri SEZGIN**-[Email](acnnurisezgin@gmail.com)

## Licence

```
Copyright 2018 Nuri SEZGİN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```