package org.crazyit.app.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enrolment.class)
public abstract class Enrolment_ {

	public static volatile SingularAttribute<Enrolment, Integer> year;
	public static volatile SingularAttribute<Enrolment, Student> student;
	public static volatile SingularAttribute<Enrolment, Integer> enrolmentId;
	public static volatile SingularAttribute<Enrolment, Course> course;
	public static volatile SingularAttribute<Enrolment, Integer> semester;

}

