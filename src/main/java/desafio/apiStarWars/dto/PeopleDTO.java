package desafio.apiStarWars.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeopleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;
	
//	private List<FilmsDTO> films = new ArrayList<>();
//	private List<SpeciesDTO> species = new ArrayList<>();
//	private List<VehiclesDTO> vehicles = new ArrayList<>();
//	private List<StarshipsDTO> starships = new ArrayList<>();
	
	private String created;
	private String edited;
	private String url;
	
	
	
}
