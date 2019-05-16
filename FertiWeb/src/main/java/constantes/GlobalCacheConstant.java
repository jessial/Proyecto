package constantes;

public abstract class GlobalCacheConstant {
	
    public static final String CACHE_ROL = "rol";
    public static final String CACHE_ROLES = "roles";
    public static final String CACHE_ROLES_APP = "rolesApp";
    
    public static final String CACHE_CULTIVO = "cultivo";
    public static final String CACHE_CULTIVOS_APP = "cultivosApp";
    public static final String CACHE_CULTIVOS = "cultivos";
    
    private GlobalCacheConstant() {
        throw new IllegalStateException("Utility class");
      }
}
