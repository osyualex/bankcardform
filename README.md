[![Build status](https://ci.appveyor.com/api/projects/status/jl1j8fsurb4bpsvv?svg=true)](https://ci.appveyor.com/project/osyualex/bankcardform)




class bankcardformTest {

    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("chromedriver.chrome.driver", "./bankcardform/driver/chromedriver.exe");

    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void FormAutomation() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id = 'name'] input")).sendKeys("Александр Соколов");
        driver.findElement(By.cssSelector("[data-test-id = 'phone'] input")).sendKeys("+79589999999");
        driver.findElement(By.cssSelector("[data-test-id = 'agreement'] input")).click();
        driver.findElement(By.className("button__content")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("icon_theme")).getText().trim();
        assertEquals(expected, actual);


    }


}
