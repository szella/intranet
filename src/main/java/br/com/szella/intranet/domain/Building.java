package br.com.szella.intranet.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "building")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "name" })
public class Building {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private UUID id;

	@Getter
	@Setter
	@Size(min = 1, max = 100)
	private String name;
}
