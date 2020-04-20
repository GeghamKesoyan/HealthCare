package io.project.app.patientcare.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author lilith
 */

@Entity
@Table(name = "practitioner")
public class Practitioner implements Serializable {
    
    private static final long serialVersionUID = 5005662345607157416L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    
    @Size(max = 50)
    @Column(name = "gender")
    private String gender;
    
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;
    
    @Size(max = 50)
    @Column(name = "viber")
    private String viber;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "patientRegisterDate")
    private Date patientRegisterDate;
    
    @Column(name = "birthday")
    private Date birthDate;
    
}
