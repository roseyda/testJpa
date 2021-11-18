package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entity.id.ClientEntityId;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {

  @EmbeddedId
  private ClientEntityId id;

  public ClientEntity() {
  }

  @Generated("SparkTools")
  private ClientEntity(Builder builder) {
    this.id = builder.id;
  }

  public ClientEntityId getId() {
    return id;
  }

  public void setId(ClientEntityId id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ClientEntity other = (ClientEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  /**
   * Creates builder to build {@link ClientEntity}.
   * 
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link ClientEntity}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private ClientEntityId id;

    private Builder() {
    }

    public Builder withId(ClientEntityId id) {
      this.id = id;
      return this;
    }

    public ClientEntity build() {
      return new ClientEntity(this);
    }
  }

}
