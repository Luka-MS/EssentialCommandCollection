# EssentialCommandCollectionByLuka

**Ein einfaches, vielseitiges Essentials-Plugin für Minecraft Spigot 1.19.4 mit JDK 17**
---
**Das Plugin ist noch in Entwicklung und kann Bugs enthalten**

---

## Übersicht

Dieses Plugin bietet grundlegende und nützliche Serverbefehle für Minecraft-Server, darunter Teleportation, Home-System, Moderationstools und mehr. Ideal für Serveradmins, die eine kompakte Sammlung an Essentials-Funktionen wünschen.

---

## Features

- Spawn setzen und teleportieren
- Homes setzen und teleportieren
- Spieler teleportieren
- Private Nachrichten (MSG)
- Gamemode wechseln
- Flugmodus aktivieren/deaktivieren
- Spieler kicken, bannen und entbannen
- Enderchest öffnen
- Godmode (Unverwundbarkeit)
- Spieler töten (Kill)
- Spieler muten und entmuten
- Nickname ändern
- Teleportanfragen verwalten (TPA, TPACCEPT, TPAHERE, TPALL, TPDENY, TPHERE)
- Vanish-Modus (unsichtbar werden)

---

## Voraussetzungen

- Minecraft Server: Spigot 1.19.4 (oder kompatibel, z.B. Paper)
- Java Development Kit (JDK) 17

---

## Installation

1. Plugin kompilieren (`gradle build` oder `./gradlew build`)
2. Die erzeugte JAR-Datei aus `build/libs/` in den `plugins`-Ordner deines Servers kopieren
3. Server starten oder neu starten

---

## Nutzung

Alle Befehle sind im Plugin definiert und können über die üblichen Minecraft-Befehle aufgerufen werden.  
Berechtigungen können über eine Permissions-Manager-Plugin (z.B. LuckPerms) verwaltet werden.

---

## Beispielbefehle

| Befehl       | Beschreibung                    |
|--------------|--------------------------------|
| `/setspawn`  | Setzt den Spawnpunkt           |
| `/spawn`     | Teleportiert zum Spawnpunkt    |
| `/home`      | Teleportiert zum Home          |
| `/sethome`   | Setzt dein Home                |
| `/tp <Spieler>` | Teleportiert zu einem Spieler|
| `/msg <Spieler> <Nachricht>` | Sendet private Nachricht |
| `/fly`       | Flugmodus umschalten           |
| `/ban <Spieler> [Grund]` | Spieler bannen         |
| `/unban <Spieler>` | Spieler entbannen          |
| `/mute <Spieler>` | Spieler muten              |
| `/unmute <Spieler>` | Spieler entmuten          |
| `/god`       | Godmode umschalten             |
| `/kill`      | Eigenen Tod ausführen          |
| `/nick <Name>` | Nickname setzen              |
| `/tpa <Spieler>` | Teleportanfrage senden     |
| `/tpaccept`  | Teleportanfrage annehmen       |
| `/tpdeny`    | Teleportanfrage ablehnen       |
| `/tphere <Spieler>` | Spieler zu dir teleportieren |
| `/ec [Spieler]` | Enderchest öffnen            |
| `/vanish`    | Unsichtbar-Modus an/aus        |

---


**Viel Spaß mit EssentialCommandCollectionByLuka!**
