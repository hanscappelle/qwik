# What

Simple and free sport app with a focus on healthy sport programs based on heart rate monitoring. 
Allows to calculate your maximum heart rate and provides several example training programs.  

Available in Google Play store: https://play.google.com/store/apps/details?id=be.hcpl.android.qwik

Source code can be found at: https://github.com/hanscappelle/qwik

## Version History

### 0.1.0

First release with minimal required functionality

- calculate maximum hear rate from age
- visualisation of heart rate zones based on input
- example training programs based on heart rate zones
- hyperlinks to information in general (mostly Dutch for now)

## Upcoming features, tasks, ideas

- provide translation for app content
- make a difference between men/women for calculation 
- show specific heart rates in programs (calculated values)
- allow generation of programs based on: time, target, ...
- provide some week based scheduling
- add alerts
- differentiate between programs for bicycles and running

## Sources

### Specific to Sport and Heart Rate Monitoring (Dutch)

ALLES: Heel duidelijke en beknopte info van mantel.com specifiek voor fietsers
https://www.mantel.com/blog/trainingsschema-voor-fietsers?

OMSLAGPUNT: Fondo website en bijhorende App met heel veel info, specific voor fietsen
https://kennis.knwufondo.nl/artikel/maximale-hartslag-bepalen-fietsen

ZONES: Info rond de verschillende zones van Garmin uit, meer gericht op lopen
https://www.garmin.com/nl-BE/blog/hartslagzones/

HARDWARE: keuze hartslagmeter
https://www.asadventure.com/nl/expertise-tips/Activewear/hoe-kies-je-de-beste-hartslagmeter.html

Nog niet verder bekeken
https://zoluko.nl/blogs/blogs/hartslagzones-wat-is-het-en-hoe-kun-je-ze-berekenen
https://www.bicycling.com/nl/training/a28394698/trainen-op-hartslag/

### Technical Resources

Development for Android using Jetpack compose: https://developer.android.com/compose

App themes, including generator and color tools:
https://developer.android.com/codelabs/jetpack-compose-theming#0
https://material-foundation.github.io/material-theme-builder/
https://colors.muz.li/

Kotlin vs compose version:
https://developer.android.com/jetpack/androidx/releases/compose-kotlin

Koin for dependency injection:
https://insert-koin.io/docs/quickstart/android-viewmodel
https://insert-koin.io/docs/quickstart/android-compose/

About MVVM and ui state setup:
https://medium.com/@MrAndroid/android-architecture-with-mvvm-and-uistate-f29aa5494465

Webview in compose:
https://medium.com/@kevinnzou/using-webview-in-jetpack-compose-bbf5991cfd14

linkify in text compose:
https://github.com/Khudoyshukur/LinkifyTextCompose
=> issue with dark mode because of ClickableText
https://stackoverflow.com/questions/72897975/clickabletext-composable-font-color-not-adjusting-to-dark-mode

## Dev Notes

Requires v1 release key + apk package (not app bundle ready yet)
used package be.hcpl.android.qwik on app store
min target SDK 35
feature graphic created with https://hotpot.ai/templates/google-play-feature-graphic