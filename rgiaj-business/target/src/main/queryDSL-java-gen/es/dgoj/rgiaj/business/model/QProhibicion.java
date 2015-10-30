package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProhibicion is a Querydsl query type for Prohibicion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProhibicion extends EntityPathBase<Prohibicion> {

    private static final long serialVersionUID = -187238648;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QProhibicion prohibicion = new QProhibicion("prohibicion");

    protected QCausaProhibicion causaProhibicion;

    protected QComunidadAutonoma comunidad;

    public final StringPath duracion = createString("duracion");

    public final NumberPath<Integer> envioCarta = createNumber("envioCarta", Integer.class);

    public final DateTimePath<java.util.Date> fechaCarencia = createDateTime("fechaCarencia", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaProhibicion = createDateTime("fechaProhibicion", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaRegistro = createDateTime("fechaRegistro", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaSentencia = createDateTime("fechaSentencia", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaSituacion = createDateTime("fechaSituacion", java.util.Date.class);

    public final NumberPath<Long> idOperador = createNumber("idOperador", Long.class);

    public final NumberPath<Long> idProhibicion = createNumber("idProhibicion", Long.class);

    public final NumberPath<Long> idProhibicionEnvio = createNumber("idProhibicionEnvio", Long.class);

    public final StringPath idSentencia = createString("idSentencia");

    public final DateTimePath<java.sql.Timestamp> lastUpdate = createDateTime("lastUpdate", java.sql.Timestamp.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath observaciones = createString("observaciones");

    public final StringPath organoJudicial = createString("organoJudicial");

    protected QPersona persona;

    public final StringPath persVincula = createString("persVincula");

    protected QSituacion situacion;

    protected QTipoInscripcion tipoInscripcion;

    protected QTipoProhibicion tipoProhibicion;

    public final NumberPath<Long> tipoVinculacion = createNumber("tipoVinculacion", Long.class);

    public final StringPath vinculacion = createString("vinculacion");

    public QProhibicion(String variable) {
        this(Prohibicion.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QProhibicion(Path<? extends Prohibicion> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProhibicion(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProhibicion(PathMetadata<?> metadata, PathInits inits) {
        this(Prohibicion.class, metadata, inits);
    }

    public QProhibicion(Class<? extends Prohibicion> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.causaProhibicion = inits.isInitialized("causaProhibicion") ? new QCausaProhibicion(forProperty("causaProhibicion")) : null;
        this.comunidad = inits.isInitialized("comunidad") ? new QComunidadAutonoma(forProperty("comunidad")) : null;
        this.persona = inits.isInitialized("persona") ? new QPersona(forProperty("persona"), inits.get("persona")) : null;
        this.situacion = inits.isInitialized("situacion") ? new QSituacion(forProperty("situacion")) : null;
        this.tipoInscripcion = inits.isInitialized("tipoInscripcion") ? new QTipoInscripcion(forProperty("tipoInscripcion")) : null;
        this.tipoProhibicion = inits.isInitialized("tipoProhibicion") ? new QTipoProhibicion(forProperty("tipoProhibicion")) : null;
    }

    public QCausaProhibicion causaProhibicion() {
        if (causaProhibicion == null){
            causaProhibicion = new QCausaProhibicion(forProperty("causaProhibicion"));
        }
        return causaProhibicion;
    }

    public QComunidadAutonoma comunidad() {
        if (comunidad == null){
            comunidad = new QComunidadAutonoma(forProperty("comunidad"));
        }
        return comunidad;
    }

    public QPersona persona() {
        if (persona == null){
            persona = new QPersona(forProperty("persona"));
        }
        return persona;
    }

    public QSituacion situacion() {
        if (situacion == null){
            situacion = new QSituacion(forProperty("situacion"));
        }
        return situacion;
    }

    public QTipoInscripcion tipoInscripcion() {
        if (tipoInscripcion == null){
            tipoInscripcion = new QTipoInscripcion(forProperty("tipoInscripcion"));
        }
        return tipoInscripcion;
    }

    public QTipoProhibicion tipoProhibicion() {
        if (tipoProhibicion == null){
            tipoProhibicion = new QTipoProhibicion(forProperty("tipoProhibicion"));
        }
        return tipoProhibicion;
    }

}

