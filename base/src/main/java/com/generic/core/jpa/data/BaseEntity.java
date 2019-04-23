package com.generic.core.jpa.data;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * The type Base entity.
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The Id.
     */
    @Id
    @Column( updatable = false, nullable = false )
    @GenericGenerator( name = "assigned-identity",
            strategy = "AssignableIdGenerator" )
    @GeneratedValue( generator = "assigned-identity", strategy = IDENTITY )
    protected Long id;

    /**
     * The Creator id.
     */
    @Column(updatable = false)
    protected Long createdBy = 0L;

    /**
     * The Created time.
     */
    @UpdateTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdTime;

}
