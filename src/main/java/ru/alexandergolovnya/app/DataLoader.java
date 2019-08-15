//package ru.alexandergolovnya.app;
//
//import ru.alexandergolovnya.domain.entity.Faculty;
//import ru.alexandergolovnya.domain.entity.user.Role;
//import ru.alexandergolovnya.domain.entity.user.State;
//import ru.alexandergolovnya.domain.entity.user.User;
//import ru.alexandergolovnya.domain.repository.FacultyRepository;
//import ru.alexandergolovnya.domain.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements ApplicationRunner {
//
//    private UserRepository userRepository;
//    private FacultyRepository facultyRepository;
//
//    @Autowired
//    public DataLoader(UserRepository userRepository, FacultyRepository facultyRepository) {
//        this.userRepository = userRepository;
//        this.facultyRepository = facultyRepository;
//    }
//
//    public void run(ApplicationArguments args) {
//        userRepository.save(new User("admin", "$2a$10$IHNNUpR3EIjZOrXON9HW8.Tl.1fQJQQiAwWwNuWthRiZWJB7mBNke", "Александр", "Константинович", "Головня", Role.ROLE_ADMIN, State.ACTIVE));
//
//        facultyRepository.save(new Faculty("Факультет компьюетрных наук", "Факультет компьюетрных наук — ведущий образовательный и научно-исследовательский центр в области IT-индустрии в Крыму, осуществляющий фундаментальную подготовку по программам бакалавриата, магистратуры и аспирантуры в области компьюетрных наук."));
//        facultyRepository.save(new Faculty("Факультет общественных наук и международных отношений", "Есть много вариантов Lorem Ipsum, но большинство из них имеет не всегда приемлемые модификации, например, юмористические вставки или слова, которые даже отдалённо не напоминают латынь. Если вам нужен Lorem Ipsum для серьёзного проекта, вы наверняка не хотите какой-нибудь шутки, скрытой в середине абзаца."));
//        facultyRepository.save(new Faculty("Факультет финансов, экономики и управления", "Выпускники института являются востребованными на рынке труда, что подтверждает качество полученного образования. Благодаря наличию различных образовательных направлений и профилей, выпускники могут реализовать себя в будущем, работая экономистами, маркетологами, финансовыми аналитиками, бухгалтерами, аудиторами, менеджерами различного уровня. Образовательные программы ИФЭиУ дают возможность получить не только фундаментальные теоретические знания в сфере экономики, финансов, учета и менеджмента, но и практические навыки работы в данных сферах."));
//        facultyRepository.save(new Faculty("Юридический факультет", "Юридический институт Севастопольского государственного университета образован 18 мая 2015 года. Это новое структурное подразделение СевГУ, которое осуществляет фундаментальную подготовку по направлению «Юриспруденция». Студенты готовятся к следующим видам профессиональной деятельности: нормотворческая, правоприменительная, правоохранительная, экспертно-консультационная, педагогическая."));
//        facultyRepository.save(new Faculty("Морской факультет", "Морской институт в составе СевГУ — ведущий центр морского образования в Крыму, готовящий специалистов как для морских судов (судоводители, судомеханики и электромеханики), так и береговых предприятий морского профиля (кораблестроители, специалисты по судовому электрооборудованию и судовой автоматике)."));
//
//    }
//}
