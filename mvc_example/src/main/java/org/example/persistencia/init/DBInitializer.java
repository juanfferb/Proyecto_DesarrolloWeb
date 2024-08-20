package org.example.persistencia.init;

import java.util.Arrays;
import java.util.List;

import org.example.persistencia.model.Company;
import org.example.persistencia.model.Division;
import org.example.persistencia.model.Person;
import org.example.persistencia.model.Role;
import org.example.persistencia.model.Conductor;
import org.example.persistencia.repository.CompanyRepository;
import org.example.persistencia.repository.DivisionRepository;
import org.example.persistencia.repository.PersonRepository;
import org.example.persistencia.repository.RoleRepository;
import org.example.persistencia.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public void run(String... args) throws Exception {

        Conductor conductor1 = new Conductor("Juan Pérez", "1234567890", "+123456789", "Calle Falsa 123");
        Conductor conductor2 = new Conductor("María López", "0987654321", "+987654321", "Avenida Siempreviva 742");
        Conductor conductor3 = new Conductor("Carlos García", "1122334455", "+1122334455", "Boulevard de los Sueños 1010");
        Person person1 = new Person("John", "Doe", "john.doe@example.com");
        Person person2 = new Person("Jane", "Doe", "jane.doe@example.com");
        Person person3 = new Person("Bob", "Smith", "bob.smith@example.com");
        Person person4 = new Person("Alice", "Johnson", "alice.johnson@example.com");
        Person person5 = new Person("Tom", "Jones", "tom.jones@example.com");
        Person person6 = new Person("Emily", "Wilson", "emily.wilson@example.com");
        Person person7 = new Person("David", "Lee", "david.lee@example.com");
        Person person8 = new Person("Lucy", "Chen", "lucy.chen@example.com");
        Person person9 = new Person("Michael", "Wang", "michael.wang@example.com");
        Person person10 = new Person("Grace", "Zhang", "grace.zhang@example.com");

        Company company1 = new Company("Acme Inc.");
        Company company2 = new Company("Globex Corporation");
        Company company3 = new Company("Initech");
        Company company4 = new Company("Umbrella Corporation");
        Company company5 = new Company("Wayne Enterprises");

        Division division1 = new Division("Marketing");
        Division division2 = new Division("Sales");
        Division division3 = new Division("Finance");
        Division division4 = new Division("Research");
        Division division5 = new Division("Product Development");
        Division division6 = new Division("Customer Support");
        Division division7 = new Division("Human Resources");
        Division division8 = new Division("Information Technology");
        Division division9 = new Division("Legal");
        Division division10 = new Division("Operations");

        Role role1 = new Role("Accountant", person1, division1);
        Role role2 = new Role("Manager", person1, division2);
        Role role3 = new Role("Sales representative", person3, division3);
        Role role4 = new Role("PR", person4, division3);


        division1.setCompany(company1);
        company1.addDivision(division1);
        division2.setCompany(company1);
        company1.addDivision(division2);
        division3.setCompany(company2);
        company2.addDivision(division3);
        division4.setCompany(company2);
        company2.addDivision(division4);
        division5.setCompany(company2);
        company2.addDivision(division5);
        division6.setCompany(company3);
        company3.addDivision(division6);
        division7.setCompany(company3);
        company3.addDivision(division7);
        division8.setCompany(company4);
        company4.addDivision(division8);
        division9.setCompany(company5);
        company5.addDivision(division9);
        division10.setCompany(company5);
        company5.addDivision(division10);

        company1.addEmployee(person1);
        person1.addEmployer(company1);
        company1.addEmployee(person2);
        person2.addEmployer(company1);
        company1.addEmployee(person3);
        person3.addEmployer(company1);

        company2.addEmployee(person3);
        person3.addEmployer(company2);
        company2.addEmployee(person4);
        person4.addEmployer(company2);
        company2.addEmployee(person5);
        person5.addEmployer(company2);

        company3.addEmployee(person4);
        person4.addEmployer(company3);
        company3.addEmployee(person5);
        person5.addEmployer(company3);
        company3.addEmployee(person6);
        person6.addEmployer(company3);

        company4.addEmployee(person6);
        person6.addEmployer(company4);
        company4.addEmployee(person7);
        person7.addEmployer(company4);
        company4.addEmployee(person8);
        person8.addEmployer(company4);

        company5.addEmployee(person8);
        person8.addEmployer(company5);
        company5.addEmployee(person9);
        person9.addEmployer(company5);
        company5.addEmployee(person10);
        person10.addEmployer(company5);

        List<Person> persons = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8,
                person9, person10);
        List<Company> companies = Arrays.asList(company1, company2, company3, company4, company5);
        List<Division> divisions = Arrays.asList(division1, division2, division3, division4, division5, division6,
                division7, division8, division9, division10);
        List<Role> roles = Arrays.asList(role1, role2, role3, role4);

        List<Conductor> conductores = Arrays.asList(conductor1, conductor2, conductor3);

        conductorRepository.saveAll(conductores);
        personRepository.saveAll(persons);
        divisionRepository.saveAll(divisions);
        companyRepository.saveAll(companies);
        roleRepository.saveAll(roles);

        

    }

}
