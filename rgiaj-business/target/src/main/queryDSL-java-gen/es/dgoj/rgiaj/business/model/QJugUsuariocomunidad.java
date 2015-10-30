package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugUsuariocomunidad is a Querydsl query type for JugUsuariocomunidad
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugUsuariocomunidad extends EntityPathBase<JugUsuariocomunidad> {

    private static final long serialVersionUID = -442482668;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugUsuariocomunidad jugUsuariocomunidad = new QJugUsuariocomunidad("jugUsuariocomunidad");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    protected QJugComunidad jugComunidad;

    public final StringPath usuario = createString("usuario");

    public QJugUsuariocomunidad(String variable) {
        this(JugUsuariocomunidad.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugUsuariocomunidad(Path<? extends JugUsuariocomunidad> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugUsuariocomunidad(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugUsuariocomunidad(PathMetadata<?> metadata, PathInits inits) {
        this(JugUsuariocomunidad.class, metadata, inits);
    }

    public QJugUsuariocomunidad(Class<? extends JugUsuariocomunidad> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jugComunidad = inits.isInitialized("jugComunidad") ? new QJugComunidad(forProperty("jugComunidad")) : null;
    }

    public QJugComunidad jugComunidad() {
        if (jugComunidad == null){
            jugComunidad = new QJugComunidad(forProperty("jugComunidad"));
        }
        return jugComunidad;
    }

}

