package controladores;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Analisis;
import dominio.CultivoSembrado;
import dominio.Lugar;
import dominio.Parcela;
import dominio.Rol;
import dominio.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import persistencia.entidad.AnalisisEntidad;
import persistencia.entidad.CultivoSembradoEntidad;
import persistencia.entidad.RolEntidad;
import persistencia.repositorio.AnalisisRepository;
import persistencia.repositorio.CultivoSembradoRepository;
import persistencia.repositorio.ParcelaRepository;
import persistencia.repositorio.RolRepository;
import persistencia.repositorio.UsuarioRepository;

@AllArgsConstructor
@NoArgsConstructor
public class ControladorDatos {

	@Autowired
	private DozerBeanMapper mapperDozer;

	@Autowired
	private AnalisisRepository analisisRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private CultivoSembradoRepository cultivoSembradoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ParcelaRepository parcelaRepository;

	public void guardarAnalisis(Analisis analisisSuelo) {
		AnalisisEntidad analisisEntidad = new AnalisisEntidad();
		mapperDozer.map(analisisSuelo, analisisEntidad);
		analisisRepository.save(analisisEntidad);
	}

	public List<Rol> consultarRoles() {
		List<Rol> roles = new ArrayList<>();
		mapperDozer.map(roles, rolRepository.findAll());
		return roles;
	}

	public List<CultivoSembrado> consultarCultivo() {
		List<CultivoSembrado> tiposCultivo = new ArrayList<>();
		List<CultivoSembradoEntidad> tiposCultivoEntidad = cultivoSembradoRepository.findAll();
		mapperDozer.map(tiposCultivoEntidad, tiposCultivo);
		return tiposCultivo;
	}

	public void guardarTipoCultivo(CultivoSembrado cultivoSembrado) {
		CultivoSembradoEntidad tipoCultivoEntidad = new CultivoSembradoEntidad();
		mapperDozer.map(cultivoSembrado, tipoCultivoEntidad);
		cultivoSembradoRepository.save(tipoCultivoEntidad);
	}

	public void guardarRol(Rol rol) {
		RolEntidad rolEntidad = new RolEntidad();
		mapperDozer.map(rol, rolEntidad);
		rolRepository.save(rolEntidad);
	}

	public Usuario consultarPorCedula(Long cedula) {
		Usuario usuario = new Usuario();
		mapperDozer.map(usuarioRepository.findById(cedula), usuario);
		return usuario;
	}

	public Rol consultarRolPorCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rol consultarRolPorCodigo(Long codigoRol) {
		Rol rol = new Rol();
		mapperDozer.map(rolRepository.findById(codigoRol), rol);
		return rol;
	}

	public List<Lugar> consultarLugaresPorUsuario(Long cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Parcela> consultarParcelasPorLugares(List<Lugar> lugares) {
		List<Parcela> parcelas = new ArrayList<>();
		List<Long> codigos = new ArrayList<>();
		for (Lugar lugar : lugares) {
			codigos.add(lugar.getCodigoLugar());
		}
		mapperDozer.map(parcelaRepository.findByCodigoParcelaIn(codigos), parcelas);
		return parcelas;
	}

	public List<Analisis> consultarAnalisisPorParcela(List<Parcela> parcelas) {
		List<Analisis> analisis = new ArrayList<>();
		List<Long> codigos = new ArrayList<>();
		for (Parcela parcela : parcelas) {
			codigos.add(parcela.getCodigoParcela());
		}
		mapperDozer.map(analisisRepository.findByCodigoParcelaIn(codigos), analisis);
		return analisis;
	}

}
