package br.com.accountbank.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "cardtype", indexes = {
        @Index(name = "cardtype_name_index", columnList = "name", unique = true)
})
@Entity
public class CardType implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public CardType() {
		super();
	}
	

	public CardType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardType cardType = (CardType) o;
        return id != null && Objects.equals(id, cardType.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
