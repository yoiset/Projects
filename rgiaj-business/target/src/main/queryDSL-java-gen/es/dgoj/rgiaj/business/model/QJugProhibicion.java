package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugProhibicion is a Querydsl query type for JugProhibicion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugProhibicion extends EntityPathBase<JugProhibicion> {

    private static final long serialVersionUID = 2018945808;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugProhibicion jugProhibicion = new QJugProhibicion("jugProhibicion");

    public final StringPath duracion = createString("duracion");

    public final NumberPath<Integer> envioCarta = createNumber("envioCarta", Integer.class);

    public final DateTimePath<java.util.Date> fechaCarencia = createDateTime("fechaCarencia", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaProhibicion = createDateTime("fechaProhibicion", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaRegistro = createDateTime("fechaRegistro", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaSentencia = createDateTime("fechaSentencia", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaSituacion = createDateTime("fechaSituacion", java.util.Date.class);

    public final NumberPath<Long> idProhibicion = createNumber("idProhibicion", Long.class);

    public final NumberPath<Long> idProhibicionEnvio = createNumber("idProhibicionEnvio", Long.class);

    public final StringPath idSentencia = createString("idSentencia");

    protected QJugComunidad jugComunidad;

    protected QJugPersona jugPersona;

    protected QJugSituacion jugSituacion;

    protected QJugTipoProhibicion jugTipoProhibicion;

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath observaciones = createString("observaciones");

    public final StringPath organoJudicial = createString("organoJudicial");

    public final StringPath personaVinculacion = createString("personaVinculacion");

    public final StringPath vinculacion = createString("vinculacion");

    public QJugProhibicion(String variable) {
        this(JugProhibicion.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugProhibicion(Path<? extends JugProhibicion> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugProhibicion(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugProhibicion(PathMetadata<?> metadata, PathInits inits) {
        this(JugProhibicion.class, metadata, inits);
    }

    public QJugProhibicion(Class<? extends JugProhibicion> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jugComunidad = inits.isInitialized("jugComunidad") ? new QJugComunidad(forProperty("jugComunidad")) : null;
        this.jugPersona = inits.isInitialized("jugPersona") ? new QJugPersona(forProperty("jugPersona"), inits.get("jugPersona")) : null;
        this.jugSituacion = inits.isInitialized("jugSituacion") ? new QJugSituacion(forProperty("jugSituacion")) : null;
        this.jugTipoProhibicion = inits.isInitialized("jugTipoProhibicion") ? new QJugTipoProhibicion(forProperty("jugTipoProhibicion")) : null;
    }

    public QJugComunidad jugComunidad() {
        if (jugComunidad == null){
            jugComunidad = new QJugComunidad(forProperty("jugComunidad"));
        }
        return jugComunidad;
    }

    public QJugPersona jugPersona() {
        if (jugPersona == null){
            jugPersona = new QJugPersona(forProperty("jugPersona"));
        }
        return jugPersona;
    }

    public QJugSituacion jugSituacion() {
        if (jugSituacion == null){
            jugSituacion = new QJugSituacion(forProperty("jugSituacion"));
        }
        return jugSituacion;
    }

    public QJugTipoProhibicion jugTipoProhibicion() {
        if (jugTipoProhibicion == null){
            jugTipoProhibicion = new QJugTipoProhibicion(forProperty("jugTipoProhibicion"));
        }
        return jugTipoProhibicion;
    }

}

