package org.crazyit.app.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, Date> effectiveEndDate;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile SingularAttribute<Category, Date> effectiveStartDate;
	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SetAttribute<Category, Product> products;

}

