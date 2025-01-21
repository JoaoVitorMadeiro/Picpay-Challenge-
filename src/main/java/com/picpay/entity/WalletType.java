package com.picpay.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "tb_wallet_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WalletType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public enum WalletTypeEnum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        WalletTypeEnum(long id, String description) {
            this.id = id;
            this.description = description;
        }

        private long id;
        private String description;
    }
}