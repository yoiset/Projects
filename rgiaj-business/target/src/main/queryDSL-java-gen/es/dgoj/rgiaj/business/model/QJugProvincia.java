package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugProvincia is a Querydsl query type for JugProvincia
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugProvincia extends EntityPathBase<JugProvincia> {

    private static final long serialVersionUID = 452422851;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugProvincia jugProvincia = new QJugProvincia("jugProvincia");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    protected QJugComunidad jugComunidad;

    public final StringPath matricula = createString("matricula");

    public QJugProvincia(String variable) {
        this(JugProvincia.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugProvincia(Path<? extends JugProvincia> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugProvincia(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugProvincia(PathMetadata<?> metadata, PathInits inits) {
        this(JugProvincia.class, metadata, inits);
    }

    public QJugProvincia(Class<? extends JugProvincia> type, PathMetadata<?> metadata, PathInits inits) {
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

