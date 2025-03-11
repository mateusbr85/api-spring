package com.avendrytech.coursespring.core.domain.entities;

import com.avendrytech.coursespring.core.domain.entities.pk.OrderItemPk;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPk id;

    private Integer quantity;

    private Double price;

    public OrderItemEntity(){}

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrder() {
        return this.id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        this.id.setOrder(order);
    }

    public ProductEntity getProduct() {
        return this.id.getProduct();
    }

    public void setProduct(ProductEntity product) {
        this.id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
