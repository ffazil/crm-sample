package com.tracebucket.infrastructure.ddd.domain;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "entityId", column = @Column(name = "ID", nullable = false))})
    protected EntityId entityId;

    @Column(name = "PASSIVE", nullable = false, columnDefinition = "boolean default false")
    @Basic(fetch = FetchType.EAGER)
    private boolean passive;

    public BaseEntity(){
        entityId = EntityId.generate();
    }

    public boolean isPassive() {
        return passive;
    }

    public void setPassive(boolean passive) {
        this.passive = passive;
    }

    public EntityId getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }
}
