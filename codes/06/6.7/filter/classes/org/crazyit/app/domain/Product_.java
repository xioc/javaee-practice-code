package org.crazyit.app.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Date> effectiveEndDate;
	public static volatile SingularAttribute<Product, Integer> stockNumber;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Date> effectiveStartDate;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SetAttribute<Product, Category> categories;

}

