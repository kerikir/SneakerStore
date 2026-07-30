# 👟 Онлайн-магазин кроссовок

[![Platform](https://img.shields.io/badge/Platform-Android-lightgrey)]()
[![Version](https://img.shields.io/badge/Version-1.0.0-blue)]()

Стильный и удобный магазин кроссовок в вашем кармане. Просматривайте категории, выбирайте лучшие модели, подбирайте цвет и размер, и легко оформляйте заказ через корзину. Данные всегда актуальны благодаря Firebase.

---

## ✨ Основные возможности

- **🏠 Стартовый экран** – яркий вход в приложение с мгновенным переходом к покупкам.
- **📱 Главный экран** – популярные категории и подборка бестселлеров. Найдите кроссовки по душе за пару касаний.
- **📂 Каталог по категориям** – выберите категорию и увидите всю обувь в ней с названием, фото, брендом, ценой и оценкой.
- **🔍 Экран товара** – подробная информация: большое изображение, цена, рейтинг, выбор размера и цвета, описание. Кнопка «Добавить в корзину» всегда под рукой.
- **🛒 Корзина** – всегда доступна с нижней панели навигации. Изменяйте количество каждого товара, видите итоговую сумму и стоимость позиций.
- **⏳ Индикатор загрузки** – если данные ещё не получены из Firebase, отображается progress bar, чтобы вы понимали, что приложение работает.

---

## 🛠 Технологический стек

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android XML](https://img.shields.io/badge/UI-XML-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)
![LiveData](https://img.shields.io/badge/LiveData-7F52FF?style=for-the-badge&logo=android&logoColor=white)
![MVVM](https://img.shields.io/badge/MVVM-FF6F00?style=for-the-badge&logo=android&logoColor=white)
![Glide](https://img.shields.io/badge/Glide-18BED4?style=for-the-badge&logo=glide&logoColor=white)

---

## 🧱 Архитектура

Приложение построено по паттерну **MVVM**, что обеспечивает чёткое разделение UI и бизнес-логики.  
**Структура слоёв:**

- **UI (View)** – XML-разметки и Activity/Fragment, наблюдающие за `LiveData` из ViewModel.
- **ViewModel** – подготовка данных, управление состояниями экрана, взаимодействие с репозиторием.
- **Repository** – получение данных из Firebase Realtime Database и предоставление их ViewModel.
- **Model** – классы данных (кроссовок, категория, элемент корзины).

Все данные о товарах, категориях и описаниях загружаются из **Firebase Database** в реальном времени. При отсутствии соединения или длительной загрузке отображается индикатор прогресса.  
Изображения загружаются с помощью **Glide**, что обеспечивает кэширование и плавное отображение.  
Навигация между экранами реализована с использованием `FragmentManager` и нижней панели навигации.

---

<img width="400" alt="Screenshot_20260427_150530_Sneaker Store" src="https://github.com/user-attachments/assets/235c43a8-bd90-4cce-955d-531186711a6b" />
<img width="400" alt="Screenshot_20260427_150542_Sneaker Store" src="https://github.com/user-attachments/assets/148cbb82-54f3-4772-ab30-c80df863be4b" />
<img width="400" alt="Screenshot_20260625_182109_Sneaker Store" src="https://github.com/user-attachments/assets/388e63ee-ba44-4195-a656-7199a733dccb" />
<img width="400" alt="Screenshot_20260627_115755_Sneaker Store" src="https://github.com/user-attachments/assets/98454dbf-9822-4b85-9fa4-65ee598d6b4c" />
<img width="400" alt="Screenshot_20260629_011424_Sneaker Store" src="https://github.com/user-attachments/assets/8bb7fd07-83ec-478e-9c05-4e0cd8fc17d0" />
<img width="400" alt="Screenshot_20260630_031401_Sneaker Store" src="https://github.com/user-attachments/assets/34c82d3d-db7d-4a2e-b183-2f268c649e9c" />
<img width="400" alt="Screenshot_20260630_031433_Sneaker Store" src="https://github.com/user-attachments/assets/1945cab0-4a19-4599-8923-2cce009c8944" />
<img width="400" alt="Screenshot_20260702_163137_Sneaker Store" src="https://github.com/user-attachments/assets/2607f38c-91ab-42ac-8701-37488b81fbd7" />
