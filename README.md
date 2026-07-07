# Star Wars Universe — SWAPI Android App

Android приложение на основе [swapi.dev](https://swapi.dev), написанное на Kotlin с использованием современного стека технологий.

## Технологии

- **Kotlin** + **Jetpack Compose** (декларативный UI)
- **Hilt** — Dependency Injection
- **Retrofit** + **OkHttp** — сетевые запросы
- **Room** — локальная база данных (кэш)
- **Navigation Compose** — навигация между экранами
- **ViewModel** + **StateFlow** — управление состоянием

## Архитектура

Проект разделён на 3 слоя:

```
data/       — Retrofit API, Room DAO, Entity, Mapper, RepositoryImpl
domain/     — Model, Repository interface, UseCase
presentation/ — ViewModel, Compose UI screens
```

## Разделы приложения

| Раздел | Описание |
|--------|----------|
| Characters | Список персонажей с пагинацией + детальный экран |
| Planets | Список планет |
| Films | Список фильмов по эпизодам |
| Starships | Список звездолётов |

## Нестандартные решения

- **Offline-first**: при ошибке сети данные берутся из Room-кэша автоматически
- **Пагинация**: персонажи подгружаются постранично при скролле (infinite scroll)
- **Star Wars тема**: тёмная тема с жёлтым акцентом (#FFE81F) в стиле вселенной
- **UiState sealed class**: единый тип состояния (Loading / Success / Empty / Error) для всех экранов
- **Bottom Navigation**: быстрый доступ ко всем 4 разделам без лишних экранов
- **Back arrow**: автоматически отображается на всех экранах кроме главных вкладок

## Запуск

1. Открыть проект в Android Studio Ladybug или новее
2. Синхронизировать Gradle
3. Запустить на эмуляторе или устройстве (minSdk 24)

<!-- Updated by bot at 2026-07-07T04:19:08.479Z -->

<!-- Updated by bot at 2026-07-07T04:19:23.232Z -->

<!-- Updated by bot at 2026-07-07T04:19:37.633Z -->

<!-- Updated by bot at 2026-07-07T04:19:52.075Z -->

<!-- Updated by bot at 2026-07-07T04:20:06.191Z -->

<!-- Updated by bot at 2026-07-07T04:20:22.010Z -->

<!-- Updated by bot at 2026-07-07T04:20:34.661Z -->

<!-- Updated by bot at 2026-07-07T04:20:48.325Z -->

<!-- Updated by bot at 2026-07-07T04:21:13.800Z -->

<!-- Updated by bot at 2026-07-07T04:21:27.828Z -->

<!-- Updated by bot at 2026-07-07T04:21:41.855Z -->

<!-- Updated by bot at 2026-07-07T04:21:54.702Z -->

<!-- Updated by bot at 2026-07-07T04:22:08.348Z -->

<!-- Updated by bot at 2026-07-07T04:22:22.189Z -->

<!-- Updated by bot at 2026-07-07T04:22:36.128Z -->

<!-- Updated by bot at 2026-07-07T04:22:49.607Z -->

<!-- Updated by bot at 2026-07-07T04:23:02.294Z -->

<!-- Updated by bot at 2026-07-07T04:23:15.581Z -->

<!-- Updated by bot at 2026-07-07T04:23:29.758Z -->

<!-- Updated by bot at 2026-07-07T04:23:43.669Z -->

<!-- Updated by bot at 2026-07-07T04:23:56.383Z -->

<!-- Updated by bot at 2026-07-07T04:24:10.586Z -->

<!-- Updated by bot at 2026-07-07T04:24:28.085Z -->

<!-- Updated by bot at 2026-07-07T04:24:45.803Z -->

<!-- Updated by bot at 2026-07-07T04:25:02.837Z -->

<!-- Updated by bot at 2026-07-07T04:25:21.764Z -->

<!-- Updated by bot at 2026-07-07T04:25:38.719Z -->

<!-- Updated by bot at 2026-07-07T04:25:55.204Z -->

<!-- Updated by bot at 2026-07-07T04:26:13.109Z -->

<!-- Updated by bot at 2026-07-07T04:26:31.364Z -->

<!-- Updated by bot at 2026-07-07T04:26:48.752Z -->

<!-- Updated by bot at 2026-07-07T04:27:06.846Z -->

<!-- Updated by bot at 2026-07-07T04:27:24.784Z -->

<!-- Updated by bot at 2026-07-07T04:27:41.669Z -->

<!-- Updated by bot at 2026-07-07T04:27:59.034Z -->

<!-- Updated by bot at 2026-07-07T04:28:16.340Z -->

<!-- Updated by bot at 2026-07-07T04:28:34.200Z -->

<!-- Updated by bot at 2026-07-07T04:28:51.457Z -->

<!-- Updated by bot at 2026-07-07T04:29:08.386Z -->

<!-- Updated by bot at 2026-07-07T04:29:25.238Z -->

<!-- Updated by bot at 2026-07-07T04:29:41.716Z -->

<!-- Updated by bot at 2026-07-07T04:29:55.221Z -->

<!-- Updated by bot at 2026-07-07T04:30:09.364Z -->

<!-- Updated by bot at 2026-07-07T04:30:23.677Z -->

<!-- Updated by bot at 2026-07-07T04:30:37.937Z -->

<!-- Updated by bot at 2026-07-07T04:30:51.792Z -->

<!-- Updated by bot at 2026-07-07T04:31:05.882Z -->

<!-- Updated by bot at 2026-07-07T04:31:18.747Z -->

<!-- Updated by bot at 2026-07-07T04:31:32.631Z -->

<!-- Updated by bot at 2026-07-07T04:31:46.563Z -->

<!-- Updated by bot at 2026-07-07T04:32:10.222Z -->

<!-- Updated by bot at 2026-07-07T04:32:24.541Z -->

<!-- Updated by bot at 2026-07-07T04:32:38.293Z -->

<!-- Updated by bot at 2026-07-07T04:32:51.657Z -->

<!-- Updated by bot at 2026-07-07T04:33:05.096Z -->

<!-- Updated by bot at 2026-07-07T04:33:28.870Z -->

<!-- Updated by bot at 2026-07-07T04:33:42.359Z -->

<!-- Updated by bot at 2026-07-07T04:33:56.092Z -->

<!-- Updated by bot at 2026-07-07T04:34:09.484Z -->

<!-- Updated by bot at 2026-07-07T04:34:23.428Z -->

<!-- Updated by bot at 2026-07-07T05:35:35.353Z -->

<!-- Updated by bot at 2026-07-07T05:35:49.537Z -->

<!-- Updated by bot at 2026-07-07T05:36:03.501Z -->

<!-- Updated by bot at 2026-07-07T05:36:17.138Z -->

<!-- Updated by bot at 2026-07-07T06:35:42.178Z -->

<!-- Updated by bot at 2026-07-07T06:35:56.504Z -->

<!-- Updated by bot at 2026-07-07T06:36:10.152Z -->

<!-- Updated by bot at 2026-07-07T06:36:24.300Z -->

<!-- Updated by bot at 2026-07-07T07:35:50.357Z -->

<!-- Updated by bot at 2026-07-07T07:36:11.011Z -->

<!-- Updated by bot at 2026-07-07T07:36:25.354Z -->

<!-- Updated by bot at 2026-07-07T08:35:44.512Z -->

<!-- Updated by bot at 2026-07-07T08:36:00.488Z -->

<!-- Updated by bot at 2026-07-07T08:36:15.556Z -->

<!-- Updated by bot at 2026-07-07T08:36:30.483Z -->

<!-- Updated by bot at 2026-07-07T09:38:37.855Z -->

<!-- Updated by bot at 2026-07-07T09:38:53.697Z -->

<!-- Updated by bot at 2026-07-07T09:39:08.882Z -->

<!-- Updated by bot at 2026-07-07T09:39:23.295Z -->

<!-- Updated by bot at 2026-07-07T09:39:47.384Z -->

<!-- Updated by bot at 2026-07-07T09:40:02.840Z -->

<!-- Updated by bot at 2026-07-07T09:40:17.506Z -->

<!-- Updated by bot at 2026-07-07T09:40:32.716Z -->

<!-- Updated by bot at 2026-07-07T09:40:47.319Z -->

<!-- Updated by bot at 2026-07-07T09:41:08.401Z -->

<!-- Updated by bot at 2026-07-07T09:41:24.539Z -->

<!-- Updated by bot at 2026-07-07T09:41:40.051Z -->

<!-- Updated by bot at 2026-07-07T09:42:04.116Z -->

<!-- Updated by bot at 2026-07-07T09:42:21.382Z -->

<!-- Updated by bot at 2026-07-07T09:42:35.846Z -->

<!-- Updated by bot at 2026-07-07T09:42:50.915Z -->

<!-- Updated by bot at 2026-07-07T09:43:04.982Z -->

<!-- Updated by bot at 2026-07-07T09:43:19.147Z -->

<!-- Updated by bot at 2026-07-07T09:43:33.184Z -->

<!-- Updated by bot at 2026-07-07T09:43:48.072Z -->

<!-- Updated by bot at 2026-07-07T09:44:04.149Z -->

<!-- Updated by bot at 2026-07-07T09:44:18.356Z -->

<!-- Updated by bot at 2026-07-07T09:44:32.492Z -->

<!-- Updated by bot at 2026-07-07T09:44:46.785Z -->

<!-- Updated by bot at 2026-07-07T09:45:13.566Z -->

<!-- Updated by bot at 2026-07-07T09:45:27.949Z -->

<!-- Updated by bot at 2026-07-07T09:45:43.184Z -->

<!-- Updated by bot at 2026-07-07T09:45:57.804Z -->

<!-- Updated by bot at 2026-07-07T09:46:14.151Z -->

<!-- Updated by bot at 2026-07-07T09:46:28.742Z -->

<!-- Updated by bot at 2026-07-07T09:46:43.527Z -->

<!-- Updated by bot at 2026-07-07T09:46:58.694Z -->

<!-- Updated by bot at 2026-07-07T09:47:13.188Z -->

<!-- Updated by bot at 2026-07-07T09:47:27.416Z -->

<!-- Updated by bot at 2026-07-07T09:47:42.182Z -->

<!-- Updated by bot at 2026-07-07T09:47:56.643Z -->
