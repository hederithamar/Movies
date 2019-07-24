# Movies Test

### Resumen: ###
Movies Test es una aplicación basada en la arquitectura limpia (clean architecture) escrita en Java.

![Screenshots](https://github.com/hederithamar/Movies/blob/master/screenshots/01.png)
![Screenshots](https://github.com/hederithamar/Movies/blob/master/screenshots/02.png)
![Screenshots](https://github.com/hederithamar/Movies/blob/master/screenshots/03.png)
![Screenshots](https://github.com/hederithamar/Movies/blob/master/screenshots/04.png)
![Screenshots](https://github.com/hederithamar/Movies/blob/master/screenshots/home.png)

### Motivacion de crear una app: ###
He estado aprendiendo sobre patrones de diseño, principios de desarrollo (SOLID) y arquitectura de aplicaciones (), estaos temas me facinan y quiero aplicalos y dispuesto a enseñar como mejoran la calidad de una aplicación para que sea mantenible y escalable, aplicando las siguientes herraminetas.

1.- El principio de responsabilidad única (SRP):
- Una clase debe tener una, y solo una, razón para cambiar.

2.- El principio abierto-cerrado (OCP):
- Las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas para extensión, pero cerradas para modificación.

3.- El principio de sustitución de Liskov (LSP):
- Las clases secundarias nunca deben romper las definiciones de tipo de la clase principal.

4.- El principio de segregación de interfaz (ISP):
- El principio de segregación de interfaz (ISP) establece que ningún cliente debe ser obligado a depender de los métodos que no utiliza.

5.- El principio de inversión de dependencia (DIP):
- Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de las abstracciones.
- Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

Estos principios son importantes a la hora de contruir codigo legible y de buena calidad, pero cumplirlos al 100 es un reto.

MVP:
El patrón MVP nos permite desacoplar los componentes, vistas, reutilizar presentadores y testear la logica de la presentación.

Arquitectura limpia(Clean architecture):
P.S: [Recomiendo leer este articulo es la feunte de inspiración de muchos desarrolladores.](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
A grandes rasgos clean propone una forma de crear aplicaciones con los siguientes principios:
- Independiente de Frameworks
- Testeable
- Independiente de la interfaz de usuario.
- Independiente de la base de datos.
- Independiente de cualquier agencia externa.

Ademas que toma los Principios SOLID como base y es adecuable a cualquier patron MVP y MVVM.

- Lenguaje de programación Java.
- Arquitectura limpia (Clean architecture).
- MVP
- Dagger2
- RxJava2
- Databinding
- Constraint Layouts
- Navigation Component
- Realm
- Flavors


### Cómo ejecutar la aplicación: ###
Esta aplicación utiliza [la API publica de MovieDB V4](https://developers.themoviedb.org/4/getting-started).
Regístrese (es gratis) y tome su api key y acces token v4, luego péguela dentro:.../res/values/api_key.xml

### //TODO: ###
- Añadir pruebas de interfaz de usuario.

### Used libraries: ###
- [Dagger2](https://github.com/google/dagger)
- [RxJava2](https://github.com/ReactiveX/RxJava)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit2](https://github.com/square/retrofit)
- [Glide](https://github.com/bumptech/glide)
- [Databinding](https://developer.android.com/topic/libraries/data-binding)
- [Constraint Layout](https://developer.android.com/training/constraint-layout)
- [Navigation architecture components](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Realm](https://github.com/realm/realm-java)
- [Timber](https://github.com/JakeWharton/timber)


### License: ###
~~~~
Copyright 2019 Heder Ithamar

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
~~~~
