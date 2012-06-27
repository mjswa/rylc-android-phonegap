# README zu RYLC-ANDROID-PHONEGAP #

Beispielcode zum Kapitel 10 Hybride Apps im Buch [Mobile Web-Apps mit JavaScript](http://www.opitz-consulting.com/go_javascriptbuch).

PhoneGap-Container für die Beispielanwendung. Zur Verwendung siehe [dort](https://github.com/mjswa/rylc-html5-phonegap).

*   Voraussetzungen:
    *   Java Development Kit 1.6 oder neuer.
    *   Apache Maven 3.0.4 oder neuer.
    *   Android SDK.
*   Bauen und Starten des Android PhoneGap-Containers für ein Profil `<profil>`:
    1.   [rylc-android-phonegap](https://github.com/mjswa/rylc-android-phonegap) klonen
    1.   PhoneGap-Container via `mvn clean install -P<profile> android:deploy android:run` bauen
         und auf einem via USB angeschlossenem Gerät ausführen.
*   Profile:
    *    `phonegapproxy`: Verwendung von [PhoneGap-Proxy](https://github.com/tigbro/phonegap-proxy), um die Beispielanwendung im Desktop-Browser auszuführen.
    *    `rylc`(default): Beispielanwendung wird direkt in den PhoneGap-Container integriert.


