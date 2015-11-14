# Clean Android Architecture for Baby Padawans
This repository shows how to separate layers of an application for newborn in Android world with a simple application based on Foursquare API.
After this you will become a babyd Padawan and this means that you have made a great progress to become a real Padawan and then a JEDI.

**Important note:** For learning puprposes this repository does not contain Dependency Injection with Dagger2 in order to be easier for newborn Android
developers.

![](https://s3.amazonaws.com/soikonomakis/Padawan.jpg)

If you understood this simple architecture you will be able to go further in Android World and more complex and cleaner architecutes
like MVP, MVVP.

The architecture is simple. Check below:

![](https://s3.amazonaws.com/soikonomakis/app_architecture.png)

A quick description is that I separated the presentation layer and the data layer.
The data layer is a simple java library and not an android library although it can be an Android Library also.
eg. if you want to access a database and you need the context.
In this repository there is a an example with a naive login/register API endpoints (check server-naive directory) and an example
to request Songs by iTunes REST API.

The data layer doesn't know anything about the presentation layer is completely agnostic about it.
The data layer can access a Database or a REST API and it will return back
to presentation layer business objects (Entities in this case).

**Important note:** You must not send back to the presentation layer the Data Object (DTO of retrofit)
because you need to have a business object with business rules (Domain layer in MVP architecture), that's why
we need DataMappers which will convert the DTO to BO.

## Architecture
* Event-Driven architecture with Otto

## Libraries
* [Retrofit 1.9.0](http://square.github.io/retrofit/)
* [OkHttp 2.4.0](http://square.github.io/okhttp/)
* [Otto Eventbus 1.3.8](http://square.github.io/otto/)
* [ButterKnife 7.0.1](https://github.com/JakeWharton/butterknife)
* [Otto Picasso 2.5.2] (http://square.github.io/picasso/)

License
-------

    Copyright 2015 Economakis Spyridon

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
