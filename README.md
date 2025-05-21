# 🎶 Rythmix Backend - [Live Demo](https://rythmix-rho.vercel.app/)

Rythmix is a music streaming application that allow users to search for songs, like tracks and playlists, and play music.

This repository contains the Spring Boot-based backend API of the Rythmix application.


# ⚙️ Install
Clone the project.
```
git clone https://github.com/SuleAktas/rythmix-be.git
```
Install dependencies
```
./mvnw clean install
```
# 💻 Run
Create .env file with the following properties
```
DATASOURCE_URL=
DATASOURCE_USER=
DATASOURCE_PASSWORD=
```
Run the spring boot
```
export $(cat .env | xargs)
./mvnw spring-boot:run
```
