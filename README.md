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
