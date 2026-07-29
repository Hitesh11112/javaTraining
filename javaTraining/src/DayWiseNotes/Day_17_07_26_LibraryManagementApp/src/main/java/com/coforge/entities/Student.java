package com.coforge.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    private String sname;
    private String branch;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    		name="stud_subj", 
    		joinColumns= @JoinColumn(name="sid"),
    		inverseJoinColumns=@JoinColumn(name="subId"))
    private List<Subject> subjectList;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId",referencedColumnName="addrid")
    private Address address;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "student")
    private LibraryCard libraryCard;
    

   
}