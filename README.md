# SecuenciaDePellProxyTDSE
Parcial TDSE

[Video Explicativo](https://youtu.be/y-r88GxWzJg)

![alt text](image-11.png)

Mediante esta arquitectura de microservicios, donde tendremos tres instancias de ec2 con diferentes propositos, sea el proxy un mediador o balanceador de carga, dado el caso de que alguna de los MathServices este caído, redirija al otro.

## MathService

Estas instancias van a tener una Api desarrollada en SpringBoot que van a calcular la secuencia de pell, de manera recursiva y devolveran una lista con cada uno de sus valores desde P(0) hasta p(N), para todo valor mayor a 2.

- Controlador:

![alt text](image-13.png)

- Excepción:

![alt text](image-14.png)

- Logica:

![alt text](image-12.png)


Prueba local Math Service

![alt text](image-15.png)

## Service Proxy

Este servicio desplegado también en una EC2 se va a encargar de redirigir a la instancia de MathService que se encuentre activa, de igual forma funciona como una Api que va a redirigir y se va a apoyar de una conexión http que se abrá hacía cada una de las instancias.

- Controlador:

![alt text](image-16.png)

- ProxyConnection:

![alt text](image-17.png)


Devolvemos un proxyBody en el controlador, ya que es lo que se nos pide en el enunciado

Prueba local Proxy redirigiendo a instancia de MathService

![alt text](image-1.png)

En este service, vamos a desarrollar la interfaz gráfica que el usuario va a ver al ingresar al browser.

![alt text](image-18.png)

![alt text](image-19.png)

## Instancias (Despliegue en AWS)

Creando instancias en AWS

![alt text](image-2.png)

Instalando en EC2 java 17

![alt text](image-4.png)

Pasando .class de MathService a EC2

![alt text](image-3.png)

Desplegue funcional en Ec2 de PellSeq

![alt text](image-5.png)

Despliegue funcional de la segunda Ec2 de PellSeq

![alt text](image-6.png)

Probando desde Postman la peticion directamente hacia la instancia

![alt text](image-7.png)

## Proxy Server

Despliegue del proxy server en una instancia de EC2 y prueba desde postamn

![alt text](image-8.png)

Despliegue Exitoso en EC2 del proxy server:

![alt text](image-10.png)


