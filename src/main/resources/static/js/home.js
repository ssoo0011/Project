function categoryChange(e) {
    const state = document.getElementById("state");

    const gangwon = ["강릉시","동해시","삼척시","속초시","원주시","춘천시","태백시","고성군","양구군","양양군","영월군","인제군","정선군","철원군","평창군","홍천군","화천군","횡성군"];
    const gyeonggi = ["고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시","가평군","양평군","여주군","연천군"];
    const gyeongsangnam = ["거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군"];
    const gyeongsangbuk = ["경산시","경주시","구미시","김천시","문경시","상주시","안동시","영주시","영천시","포항시","고령군","군위군","봉화군","성주군","영덕군","영양군","예천군","울릉군","울진군","의성군","청도군","청송군","칠곡군"];
    const gwangju = ["전체"];
    const daegu = ["전체"];
    const daejeon = ["전체"];
    const busan = ["전체"];
    const seoul = ["전체"];
    const ulsan = ["전체"];
    const incheon = ["전체"];
    const jeonnam = ["광양시","나주시","목포시","순천시","여수시","강진군","고흥군","곡성군","구례군","담양군","무안군","보성군","신안군","영광군","영암군","완도군","장성군","장흥군","진도군","함평군","해남군","화순군"];
    const jeonbuk = ["군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군"];
    const jeju = ["서귀포시","제주시","남제주군","북제주군"];
    const chungbuk = ["제천시","청주시","충주시","괴산군","단양군","보은군","영동군","옥천군","음성군","증평군","진천군","청원군"];
    const chungnam = ["계룡시", "공주시", "금산군", "논산시", "당진시", "보령시", "부여군", "서산시", "서천군", "아산시", "예산군", "천안시", "청양군", "태안군", "홍성군"];



    if (e.value == "32") {
        add = gangwon;
    } else if (e.value == "31") {
        add = gyeonggi;
    } else if (e.value == "36") {
        add = gyeongsangnam;
    } else if (e.value == "35") {
        add = gyeongsangbuk;
    } else if (e.value == "5") {
        add = gwangju;
    } else if (e.value == "4") {
        add = daegu;
    } else if (e.value == "3") {
        add = daejeon;
    } else if (e.value == "6") {
        add = busan;
    } else if (e.value == "1") {
        add = seoul;
    } else if (e.value == "7") {
        add = ulsan;
    } else if (e.value == "2") {
        add = incheon;
    } else if (e.value == "38") {
        add = jeonnam;
    } else if (e.value == "37") {
        add = jeonbuk;
    } else if (e.value == "39") {
        add = jeju;
    } else if (e.value == "34") {
        add = chungnam;
    } else if (e.value == "33") {
        add = chungbuk;
    }

    state.options.length = 1;
    // 군/구 갯수;

    for (property in add) {
        let opt = document.createElement("option");
        opt.value = add[property];
        opt.innerHTML = add[property];
        state.appendChild(opt);
    }
}