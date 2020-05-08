// vendor
import React from 'react';
import { NavLink } from 'react-router-dom';
// proj
import Rules from '../../styles/images/icons/rules.svg';
import { book } from '../../routes';

const PrivacyPolicyContainer = () => (
    <div className='container'>
        <div className='content'>
            <div className='title'>
                ПРАВИЛА КОНКУРСУ “EPAM BOT CHALLENGE”,
                <br />
                організованого ТОВ «ЕПАМ РІШЕННЯ»
                <br />
                <div className='notation'>(тут і далі – Правила)</div>
            </div>
            <div className='subTitle'>§1 Загальна інформація</div>
            <ol>
                <li>
                    1. Ці правила конкурсу включають у себе правила та умови
                    участі в конкурсі EPAM BOT CHALLENGE (тут і далі - Конкурс).
                </li>
                <li>
                    2. Організатором Конкурсу є компанія ТОВ «ЕПАМ РІШЕННЯ»,
                    розташована за адресою: м. Київ, вул. Фізкультури 28, 03150
                    (тут і далі - Організатор).
                </li>
                <li>
                    3. Належне проведення конкурсу буде контролюватися
                    представниками, призначеними Організатором, відповідальними
                    щодо технічних і основних питань (далі – Представники
                    Організатора). У разі будь-яких запитань стосовно Конкурсу з
                    Організатором можна зв’язатися за електронною адресою:
                    OrgBotChallengeUA@epam.com.
                </li>
                <li>4. Конкурс проходитиме на території України.</li>
                <li>
                    5. Конкурс буде проводитися в онлайн-форматі на веб-сайті{ ' ' }
                    <a href={ process.env.REACT_APP_EVENT_LINK }>
                        { process.env.REACT_APP_EVENT_LINK }
                    </a>{ ' ' }
                    (тут і далі – Сайт Конкурсу).
                </li>
                <li>
                    6. Конкурс проводиться з метою привернення уваги осіб
                    зацікавлених в IT-галузі до діяльності  ТОВ «ЕПАМ РІШЕННЯ»,
                    сприяння розвитку інновацій та впровадження сучасних
                    технологій.
                </li>
                <li>
                    7. Конкурс не є лотереєю або послугою у сфері грального
                    бізнесу.
                </li>
            </ol>
            <div className='subTitle'>§2 Правила конкурсу</div>
            <ol>
                <li>
                    1. Конкурс відкритий для будь-якої фізичної особи з повною
                    цивільною правоздатністю і дієздатністю, за умови, що вона
                    відповідає наступним умовам:
                    <ol>
                        <li>1) вік - не молодше 18 років;</li>
                        <li>
                            2) володіє чи має змогу користуватися комп'ютером чи
                            ноутбуком з доступом до мережі Інтернет. Учасник
                            оплачує доступ в мережу Інтернет самостійно;
                        </li>
                        <li>
                            3) зареєструється на Сайті Конкурсу шляхом
                            заповнення анкети;
                        </li>
                        <li>
                            4) ознайомлена та погодилася з Правилами конкурсу і
                            &nbsp;
                            <span>
                                <NavLink to={ book.privacyPolicy }>
                                    Політикою конфіденційності персональних
                                    даних Відвідувачів сайту
                                </NavLink>
                            </span>
                            &nbsp;(надалі – Політика конфіденційності) (активне
                            посилання на Політику) та надала Згоду на обробку
                            персональних даних (активне посилання на Згоду) у
                            відповідному розділі онлайн-реєстрації на Конкурс
                            (згаданої у підпункті 3 пункту 1 розділу 2 цих
                            Правил);
                        </li>
                        <li>
                            5) має реєстраційний номер облікової картки платника
                            податків з Державного реєстру фізичних
                            осіб-платників податків.
                        </li>
                    </ol>
                </li>
                <li>
                    2. Особа, яка відповідає вимогам викладеним у п.1 розділу 2
                    Правил Конкурсу та бажає прийняти участь у Конкурсі, шляхом
                    виконання необхідних дій визначних цими Правилами, стає
                    учасником Конкурсу (тут і далі - Учасник).
                </li>
                <li>
                    3. У Конкурсі не мають права приймати участь співпрацівники
                    Організатора, особи, найняті ним на основі договору
                    цивільно-правового характеру та члени родин осіб, які
                    перебувають з Організатором в трудових та/або
                    цивільно-правових відносинах;
                </li>
                <li>
                    4. Організатор має право (але не зобов’язаний) перевіряти та
                    видаляти заявки на участь, що не відповідають підпунктам 1-4
                    пункту 1 розділу 2 Правил Конкурсу. Організатор залишає за
                    собою право видалення з Сайту Конкурсу тих Учасників, які
                    порушують правила участі у Конкурсі, особливо положення, які
                    захищають конфіденційність третіх сторін.
                </li>
                <li>
                    5. Погоджуючись з Політикою конфіденційності та Згодою на
                    обробку даних, Учасник дає згоду на обробку своїх
                    персональних даних, переданих Організатору Конкурсу.
                </li>
                <li>
                    6. Учасник також дає згоду на публікацію його імені
                    (вказаного при реєстрації на Конкурс) в турнірній таблиці
                    Конкурсу й анонсах результатів Конкурсу в соціальних
                    мережах.
                </li>
                <li>
                    7. У Конкурсі використовуються мови програмування Java,
                    JavaScript, .Net/C#, Python, Go, але участь не вимагає від
                    Учасника експертних навичок володіння даними мовами
                    програмування. Організатор надає додаткові матеріали:
                    WebSocket клиєнти (заготовки для ботів) для мов Java,
                    JavaScript, .Net/C#, Python, Go які можна завантажити з
                    Сайту Конкурсу{ ' ' }
                    <a href={ process.env.REACT_APP_EVENT_LINK }>
                        { process.env.REACT_APP_EVENT_LINK }
                    </a>
                    .
                </li>
                <li>8. Кількість Учасників Конкурсу необмежена.</li>
                <li>
                    9. Учасники під час участі в Конкурсі зобов’язуються:
                    <ol>
                        <li>
                            9.1. дотримуватися вимог цих Правил та норм чинного
                            законодавства України;
                        </li>
                        <li>
                            9.2. вказувати повні, коректні та достовірні
                            відомості про себе, що дасть змогу ідентифікувати
                            Учасника у випадку виграшу у Конкурсі;
                        </li>
                        <li>
                            9.3. свідомо не завдавати незручностей та не чинити
                            перешкод іншим Учасникам;
                        </li>
                        <li>
                            9.4. не чинити дій, що ставлять під сумнів
                            правомірність участі такого Учасника в Конкурсі.
                        </li>
                    </ol>
                </li>
                <li>
                    10. Надання Учасником даного Конкурсу
                    невірних/неіснуючих/недостовірних/чужих даних, у т.ч.
                    вигаданих, звільняє Організатора від обов’язку
                    вручити/надіслати Приз передбачений умовами Конкурсу, і
                    такий Учасник, який здобув право на отримання Призів, але
                    надав невірні/неіснуючі/недостовірні/чужі дані, втрачає
                    право на отримання такого Призу.
                </li>
            </ol>
            <div className='subTitle'>
                §3 Проведення Конкурсу, призи та умови їх отримання
            </div>
            <ol>
                <li>
                    1. Конкурс проводиться в онлайн-форматі з 9.00 години
                    18.05.2020 до 19.00 години 29.05.2020 року. Реєстрація на
                    Конкурс розпочинається о 9.00 годині 18.05.2020 і
                    закінчується о 19.00 годині 28.05.2012. Кожен Ігровий день
                    розпочинається о 9:00 і закінчується о 19:00 (тут і далі –
                    Ігровий день). Будь-яка участь у Конкурсі в інші строки, ніж
                    зазначено в цьому пункті Правил, не враховується при
                    визначенні Переможців Конкурсу по завершенню Конкурсу. 
                </li>
                <li>
                    2. Конкурс базується на комбінації стратегічних навичок
                    програмування та елементів штучного інтелекту. Формат
                    Конкурсу - турнір ботів у формі різновиду гри Бомбермен.
                </li>
                <li>
                    3. Завдання кожного Учасника полягає у створенні розумного
                    бота, який отримає найбільшу кількість Балів в один з
                    Ігрових днів, потрапить до Фіналу і обіграє ботів інших
                    Учасників у фіналі за кількістю Балів.
                </li>
                <li>
                    4. Усі Боти, що будуть створені Учасниками, будуть змагатися
                    з ботами інших Учасників у численних Раундах.  В рамках
                    Конкурсу кожен гравець буде змагатися проти інших Учасників.
                </li>
                <li>
                    5. Змагання проходитимуть на Сайті Конкурсу у Кімнатах по
                    декілька Учасників на одному Полі.
                </li>
                <li>
                    6. Кожна Кімната на Сайті Конкурсу грає декілька Раундів.
                    Один Раунд триватиме не закiнчиться час Раунду, але не довше
                    тривалості Ігрового дня.
                </li>
                <li>
                    7. Після серії із кількох Раундів у одній Кімнаті на Сайті
                    Конкурсу, Кімнату Учаснику буде змінено автоматично на іншу
                    Кімнату на Сайті Конкурсу із іншим складом Учасників.
                </li>
                <li>
                    8. Вигляд Поля на Сайті Конкурсу а також Час Раунду може
                    бути змінено від одного ігрового дня до іншого.
                </li>
                <li>
                    9. На ігровому Полі на Сайті Конкурсу присутні як Учасники,
                    так і різноманітні ігрові Елементи (перешкоди, бонуси тощо).
                    За взаємодію з цими Елементами можуть нараховуватись як
                    бонусні, так і штрафні Бали (детальніше на Сайті Конкурсу{ ' ' }
                    <a href={ process.env.REACT_APP_EVENT_LINK }>
                        { process.env.REACT_APP_EVENT_LINK }
                    </a>{ ' ' }
                    у розділі “Правила гри”).
                </li>
                <li>
                    10. За один Iгровий День кожен Учасник матиме можливість
                    заробити певну кількість Балів, які сумуються впродовж всіх
                    Матчів/Раундів за цей проміжок часу.
                </li>
                <li>
                    11. Переможцями Ігрового Дня вважаються 10 Ботів Учасників
                    за результатами всіх Раундів Ігрового Дня на день та годину
                    закриття Ігрового Дня.
                </li>
                <li>
                    12. Тільки Учасники, які набрали більше 0 Балів протягом
                    Ігрового Дня можуть стати Переможцями Ігрового Дня.
                </li>
                <li>
                    13. Якщо на останнє місце (10-те) будуть претендувати більше
                    ніж один Учасник (отримано однакову кількість Балів) - всі
                    вони обираються Переможцями цього Iгрового Дня.
                </li>
                <li>
                    14. Переможці кожного Ігрового дня автоматично потрапляють
                    до Фіналу, який відбудеться останнього дня Конкурсу
                    (29.05.2020).
                </li>
                <li>
                    15. Учасники, що не потрапили до списку Переможців у
                    будь-який Ігровий день Конкурсу до Фіналу, мають можливість
                    удосконалити свого Бота і спробувати потрапити до списку
                    Фіналістів у будь-який інший Ігровий День до Фіналу, тобто
                    до 28.05.2020 включно.
                </li>
                <li>
                    16. Кожного Ігрового дня буде визначено 10 унікальних
                    Фіналістів. Це означає, що Учасники, які вже потрапили до
                    числа Фіналістів в один із попередніх Ігрових днів,
                    продовжують грати і знову потрапляють до такого числа іншого
                    Ігрового дня – будуть вилучені із результатів Ігрового дня,
                    де вони знову стали Фіналістами, а Фіналістами стануть перші
                    10 Учасників, які наберуть найбільшу кількість балів і крім
                    Учасників, що увійшли до числа Фіналістів не вперше.
                </li>
                <li>
                    17. Протягом Конкурсу Учасник має змогу вдосконалювати код.
                    Це можливо у будь-який час до, під час, та після кожного
                    Раунду.
                </li>
                <li>
                    18. Слід пам’ятати, що якщо Бот під час Раунду не був
                    активований (його вдосконалюють, є наявні проблеми із
                    зв’язком тощо) - сервер виконує дію по замовчуванню, що
                    призведе до програшу в поточному Раунді.
                </li>
                <li>
                    19. Сервери Конкурсу працюватимуть 24/7, що дає змогу
                    вдосконалювати Бота у будь-який час. Але Організатор лишає
                    за собою право перезавантажувати сервери в час з 19:00 до
                    9:00 без попередньої нотифікації Учасників.
                </li>
                <li>
                    20. Змагання буде візуалізоване - раунди між усіма Ботами
                    будуть транслюватися у форматі онлайн-стріму на Сайті
                    конкурсу{ ' ' }
                    <a href={ process.env.REACT_APP_EVENT_LINK }>
                        { process.env.REACT_APP_EVENT_LINK }
                    </a>{ ' ' }
                    у розділі “Трансляція” де є можливість перейти до будь-якої
                    Кімнати, а також подивитися загальні результати по всіх
                    Кімнатах серед всіх Учасників на поточний момент кожного
                    Ігрового Дня.
                </li>
                <li>
                    21.Окрім електронної адреси OrgBotChallengeUA@epam.com для
                    спілкування між Учасниками та Організатором буде створено
                    Канал у додатку Slack, приєднатися до якого можна за{ ' ' }
                    <a href={ process.env.REACT_APP_JOIN_CHAT_LINK }>
                        посиланням <img src={ Rules } alt='rules' />
                    </a>
                    .
                </li>
                <li>
                    22. Фінал Конкурсу проходитиме подібно до Ігрового Дня із
                    такими відмінностями:
                    <ol>
                        <li>
                            22.1 Фінал Конкурсу проходитиме останнього дня
                            Конкурсу 29.05.2020
                        </li>
                        <li>
                            22.2 У Фіналі братимуть участь тільки Переможці
                            кожного Ігрового Дня Конкурсу у період з 18.05.2020
                            по 28.05.2020.
                        </li>
                        <li>
                            22.3 Перша частина Фіналу триватиме 29.05.2020 з
                            9:00 до 17:00, після чого буде обрано 10 кращих
                            Ботів Учасників за результатами всіх Раундів цієї
                            частини Фіналу - Суперфіналісти.
                        </li>
                        <li>
                            22.4 Тільки Учасники, які набрали більше 0 Балів у
                            Фіналі до 17:00 години можуть стати
                            Суперфіналістами.
                        </li>
                        <li>
                            22.5 Якщо на останнє місце (10-те) будуть
                            претендувати більше ніж один Учасник (отримано
                            однакову кількість Балів) - всі вони обираються
                            Суперфіналістами.
                        </li>
                        <li>
                            22.6 Суперфінал триватиме 29.05.2020 з 18:00 до
                            19:00 у формі серії Раундів серед Суперфіналістів.
                        </li>
                        <li>
                            22.7 Суперфінал триватиме рівно одну годину й о
                            19:00 гру буде зупинено.
                        </li>
                        <li>
                            22.8 Трьох переможців Суперфіналу буде визначено за
                            кількістю зароблених балів.
                        </li>
                    </ol>
                </li>
                <li>
                    23. Учасники, які посядуть перше, друге та третє місця в
                    турнірній таблиці Конкурсу під час фінального раунду в
                    останній день Конкурсу (тут і далі – Переможці Конкурсу)
                    отримають Призи.
                </li>
                <li>
                    Результати визначення Переможця Конкурсу буде занесено до
                    Протоколу визначення Переможців Конкурсу, який підписується
                    Представниками Організатора Конкурсу. Протокол визначення
                    Переможців Конкурсу є остаточним і оскарженню не підлягає.
                    Результати визначення Переможців Конкурсу також
                    відображаються Організатором на Сайті Конкурсу.
                </li>
                <li>
                    Результати визначення Переможців Конкурсу вважатимуться
                    остаточними та не підлягають оскарженню.
                </li>
                <li>
                    24. У разі, якщо два чи більше учасників посядуть перше,
                    друге або третє місце, перемога буде віддана тому Учаснику,
                    який здобув найбільшу кількість перемог протягом
                    попереднього періоду Конкурсу за всі Ігрові Дні до старту
                    Фіналу, тобто до 28.05.2020 включно.
                </li>
                <li>
                    25. Призи є матеріальними: ігрова консоль PlayStation 4 Pro
                    1TB за перше місце, ігрова консоль Sega Mega Drive Mini за
                    друге місце; настільна Hobby World Fallout за третє місце
                    (тут і далі – Приз, Призи). Оскільки отримувачами Призів є
                    фізичні особи, вартість таких Призів, з урахуванням пп.
                    165.1.39 п.165.1 ст.165 ПКУ, є об’єктом оподаткування
                    податком на доходи фізичних осіб і військовим збором та
                    оподатковується на загальних підставах. Сплату такого
                    податку бере на себе Організатор. Організатор надає призи
                    переможцям протягом трьох місяців з моменту оголошення
                    Переможців Конкурсу.
                </li>
                <li>
                    26. Передача Призів Переможцям Конкурсу є обов’язком
                    виключно Організатора Конкурсу. Призи будуть відправлені
                    поштою на території України за адресою, вказаною Переможцем.
                    Відправка здійснюється за рахунок Організатора.
                </li>
                <li>
                    Для отримання призу Переможець Конкурсу повинен зв’язатися з
                    Організатором за електронною адресою:
                    OrgBotChallengeUA@epam.com. При отриманні Призу потрібно
                    мати з собою паспорт та реєстраційний номер облікової картки
                    платника податків з Державного реєстру фізичних
                    осіб-платників податків для ідентифікації особи. Для
                    отримання Призу потрібно підписати Акт приймання-передачі
                    Призу і надати копію паспорта громадянина України та копію
                    реєстраційного номеру облікової картки платника податків з
                    Державного реєстру фізичних осіб-платників податків.
                </li>
                <li>
                    27. Призи, що не будуть затребувані протягом 30 днів із дня
                    закінчення Конкурсу, переходять у власність Організатора
                    Конкурсу, який має можливість скасувати приз, а Учасник,
                    який не отримав приз, не має права на подання будь-яких
                    скарг та/або претензій з цього приводу. Організатор не несе
                    відповідальності за неможливість Учасника отримати приз.
                </li>
                <li>
                    28. Приз надсилається/вручається Переможцю Конкурсу, який
                    виконав усі умови цих Правил.
                </li>
                <li>
                    29. Вручення Призу допускається лише особі, яка отримала на
                    нього право згідно з умовами цих Правил, і виключно в
                    порядку, встановленому цими Правилами.
                </li>
                <li>
                    30. Організатор має право відмовити у видачі Призу Переможцю
                    Конкурсу, якщо такий Переможець Конкурсу не виконав будь-яку
                    з умов цих Правил Конкурсу або незаконним чи нечесним
                    способом впливав шляхом втручання у роботу Сайту Конкурсу.
                    При цьому такий Переможець не має права на одержання від
                    Організатора будь-якої компенсації.
                </li>
                <li>
                    31. Організатор не несе відповідальність за будь-які
                    матеріальні чи нематеріальні збитки, нанесені Учаснику у
                    зв’язку з його участю в Конкурсі, результатом участі у
                    Конкурсі чи у зв’язку з присудженням чи не присудженням
                    призу.
                </li>
            </ol>
            <div className='subTitle'>§4 Право на використання зображень</div>
            <ol>
                <li>
                    1. Організатор має право на вільне використання зображень
                    Учасників, у вигляді фотографій чи аудіо-відео записів, з
                    метою промоції описаного вище Конкурсу, без жодних часових
                    та територіальних обмежень, на що Учасник надає безвідкличну
                    і безумовну згоду. Ця згода включає у себе можливість
                    використання зображень у таких формах:
                    <ol>
                        <li>
                            1) запис та відтворення за допомогою будь-яких
                            відомих технологій, розповсюдження у будь-якій
                            формі;
                        </li>
                        <li>
                            2) відтворення шляхом запису зображень, розміщених у
                            будь-який спосіб та на будь-яких носіях;
                        </li>
                        <li>
                            3) публічна демонстрація, презентація,
                            реконструкція, транслювання та ре-транслювання,
                            також як публічний доступ будь-якій особі у спосіб
                            та час, за її власним вибором;
                        </li>
                        <li>
                            4) розміщення та публікація у газетах, на
                            веб-сайтах, постерах та білбордах, у соціальних
                            мережах, форумах та інших медіа та інформаційних
                            носіях, промо-матеріалах, маркетингових матеріалах
                            тощо (розсилки, ліфлети, тощо);
                        </li>
                        <li>5) Телевізійні та радіо-трансляції.</li>
                    </ol>
                </li>
                <li>
                    2. Організатор залишає за собою право надавати доступ до
                    використання таких зображень Учасника пов’язаним особам.
                </li>
            </ol>
            <div className='subTitle'>§5 Передача авторського права</div>
            <ol>
                <li>
                    1. Якщо у результаті Конкурсу буде створено проект, який є
                    об’єктом авторського права, майнові права на нього будуть
                    передані Організатору, якщо він заявить про таке бажання. У
                    цьому випадку Учасник зобов’язаний укласти з Організатором
                    авторський договір про безоплатну передачу таких прав.
                </li>
                <li>
                    2. Учасник не має права вимагати від Організатора
                    компенсації за передачу такого авторського права. Учасник
                    погоджується, що він не матиме ніяких претензій щодо
                    безоплатної передачі майнових авторських прав.
                </li>
                <li>
                    3. Для того, щоб передати майнові авторські права, необхідно
                    укласти договір у письмовій формі, між Учасником і
                    Організатором, в якому сторони погодяться про передачу
                    майнових авторських прав.
                </li>
                <li>
                    4. Якщо такий договір буде укладено, Учасник зобов'язується
                    передати Організатору майнові авторські права на кожен твір,
                    створений в результаті участі в конкурсі, (якщо робота буде
                    об’єктом авторського права), у таких сферах:
                    <ol>
                        <li>
                            1) в області запису та відтворення - виготовлення та
                            запис примірників твору з використанням будь-якої
                            техніки та у будь-який спосіб включаючи друк,
                            копіювально-розмножувальні роботи, магнітний запис і
                            цифрову техніку; нанесення на всі носії незалежно
                            від системи, формату і стандарту, зокрема, на
                            аудіовізуальні носії, відеокасети, власний
                            комп'ютер, DVD, магнітну стрічку, фотоплівку,
                            аналогові плати, CD, VCD, CD-ROM для MP3-файлів,
                            флеш-диски; відтворення за допомогою будь-яких
                            засобів, зокрема, чутливих до світла, магнітних,
                            аудіовізуальних, цифрових (будь-якого типу),
                            оптичних, друку в будь-якій формі та комп'ютерного
                            запису;
                        </li>
                        <li>
                            2) в області торгівлі - випуск у продаж оригіналів
                            або копій, позика або оренда оригіналів або копій;
                        </li>
                        <li>
                            3) розповсюдження твору способами, не зазначеними у
                            підпункті 2 пункту 4 розділу 6 цих Правил - публічне
                            виконання, показ, трансляція і ретрансляція, а також
                            публічний доступ таким чином, що кожен може мати
                            доступ до нього за часом і місцем знаходження на їх
                            вибір; використання повністю або частково в мережі
                            он-лайн, в тому числі доступ до комп'ютерної пам'яті
                            або поширення у мережі засобів масової інформації, в
                            тому числі в мережі Інтернет, або надання доступу у
                            цифровому вигляді для ефірного мовлення в
                            необмеженій кількості разів;
                        </li>
                        <li>
                            4) обмін, розповсюдження твору або його частини у
                            формах публічного використання, крім зазначених
                            вище: використання для реклами, просування,
                            маркетингу, інформаційної та комерційної діяльності,
                            демонстрації, публікації (в тому числі в мережі
                            Інтернет, а також за допомогою використання
                            будь-яких телекомунікаційних послуг).
                        </li>
                        <li>
                            5) Для будь-яких випадків, не визначених в розділі 6
                            Правил Конкурсу, застосовуються положення договору
                            (та правила, встановлені у такому договорі).
                        </li>
                    </ol>
                </li>
                <li>
                    2. Учасник Конкурсу своєю участю у Конкурсі підтверджує, що
                    розуміє та погоджується з тим, що твори можуть
                    використовуватися Організатором Конкурсу повністю або
                    частково у всьому світі, без виплат винагороди за будь-яке
                    використання без подальшої компенсації або перегляду такої
                    згоди. Учасник Конкурсу також підтверджує та погоджується,
                    що Твори можуть використовуватися цілком або частково,
                    окремо або разом з іншими роботами, з будь-яким
                    використанням прав інтелектуальної власності, а також можуть
                    бути змінені, відредаговані або доповнені, використані у
                    відмінній від оригіналу або комбінованій формі, або
                    будь-яким іншим чином на розсуд Організатора.
                </li>
            </ol>
            <div className='subTitle'>§6 Заключні положення</div>
            <ol>
                <li>
                    1. Правила Конкурсу, Політика Конфіденційності та Згода на
                    обробку персональних даних розміщені на Сайті конкурсу{ ' ' }
                    <a href={ process.env.REACT_APP_EVENT_LINK }>
                        { process.env.REACT_APP_EVENT_LINK }
                    </a>
                    .
                </li>
                <li>
                    2. Організатор Конкурсу залишає за собою право скасувати
                    Конкурс у будь-який час.
                </li>
                <li>
                    3. Організатор Конкурсу залишає за собою право змінити ці
                    Правила Конкурсу в будь-який час до початку проведення
                    Конкурсу. Зміна та/або доповнення Правил Конкурсу можливе у
                    випадку їхнього оприлюднення в порядку, що визначений для
                    інформування про Конкурс. Такі зміни та доповнення набувають
                    чинності з моменту оприлюднення.
                </li>
                <li>
                    4. Питання, що не врегульовані правилами Конкурсу,
                    регулюються Цивільним кодексом України, Податковим кодексом
                    України та іншими законами України.
                </li>
                <li>
                    5. Організатор Конкурсу має право просити від кожного
                    Учасника надання даних, необхідних для належного проведення
                    Конкурсу. Надання таких даних є добровільним, але водночас є
                    необхідною умовою для участі в Конкурсі.
                </li>
            </ol>
        </div>
    </div>
);

export default PrivacyPolicyContainer;
