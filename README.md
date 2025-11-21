# FirstAndroid Project

Esta es una aplicación de Android desarrollada como parte de un proyecto de clase. La aplicación demuestra varias funcionalidades clave del desarrollo en Android, incluyendo un sistema de autenticación de usuarios, la gestión de fragmentos con `ViewPager` y `TabLayout`, y la interacción con elementos de la interfaz de usuario como `CardView` y `AlertDialog` personalizados.

## Características Principales

La aplicación se divide en varias secciones, cada una con sus propias funcionalidades:

### 1. Sistema de Autenticación

- **Registro de Usuario:**
  - Un formulario permite a los nuevos usuarios registrarse con un nombre de usuario, email y contraseña.
  - Se realizan validaciones para asegurar que todos los campos estén completos y que las contraseñas introducidas coincidan.
  - Si hay un error, se muestran mensajes informativos al usuario.

- **Login de Usuario:**
  - Los usuarios registrados pueden acceder a la aplicación a través de una pantalla de login.

### 2. Pantalla Principal y Navegación

- **Mensaje de Bienvenida:** Tras iniciar sesión, el usuario es recibido con un saludo personalizado que incluye su nombre.
- **Navegación:** Desde la pantalla principal, se puede acceder a dos secciones principales:
  - La sección de Equipos y Selecciones.
  - Una Calculadora.

### 3. Galería de Equipos y Selecciones

Esta sección está organizada en dos pestañas utilizando un `ViewPager`:

- **Pestaña "Equipos":**
  - Muestra una lista vertical de tarjetas (`CardView`).
  - Cada tarjeta contiene el escudo y el nombre de un equipo de fútbol.

- **Pestaña "Selecciones":**
  - Sigue la misma estructura, pero muestra tarjetas con las banderas y nombres de selecciones nacionales.

- **Funcionalidad Extra (Bonus):**
  - Al hacer clic en cualquier tarjeta (ya sea de un equipo o una selección), se abre un **diálogo de alerta personalizado** (`AlertDialog`).
  - Este diálogo permite al usuario **escribir un nuevo nombre** y, al pulsar "Aceptar", el texto de la tarjeta se actualiza dinámicamente.

### 4. Calculadora

- Una `Activity` separada que proporciona funcionalidades de una calculadora básica, incluyendo operaciones aritméticas.

## Capturas de Pantalla

*(Aquí puedes añadir las capturas de pantalla de tu aplicación para mostrar cómo se ve cada sección)*

**Pantalla de Login y Registro:**

`[Inserta aquí una captura de la pantalla de login]`

**Pantalla Principal con Saludo:**

`[Inserta aquí una captura de la pantalla principal]`

**Pestañas de Equipos y Selecciones:**

`[Inserta aquí una captura de la vista con las pestañas]`

**Diálogo para Cambiar Nombre:**

`[Inserta aquí una captura del AlertDialog en acción]`

**Calculadora:**

`[Inserta aquí una captura de la calculadora]`
