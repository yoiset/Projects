package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugHistoricodescargasproh is a Querydsl query type for JugHistoricodescargasproh
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugHistoricodescargasproh extends EntityPathBase<JugHistoricodescargasproh> {

    private static final long serialVersionUID = 64243116;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugHistoricodescargasproh jugHistoricodescargasproh = new QJugHistoricodescargasproh("jugHistoricodescargasproh");

    public final NumberPath<Integer> completa = createNumber("completa", Integer.class);

    public final NumberPath<Integer> confirmada = createNumber("confirmada", Integer.class);

    public final DateTimePath<java.util.Date> fechaDescarga = createDateTime("fechaDescarga", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    protected QJugComunidad jugComunidad;

    public final StringPath procedencia = createString("procedencia");

    public final NumberPath<Long> ultimo = createNumber("ultimo", Long.class);

    public QJugHistoricodescargasproh(String variable) {
        this(JugHistoricodescargasproh.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugHistoricodescargasproh(Path<? extends JugHistoricodescargasproh> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugHistoricodescargasproh(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugHistoricodescargasproh(PathMetadata<?> metadata, PathInits inits) {
        this(JugHistoricodescargasproh.class, metadata, inits);
    }

    public QJugHistoricodescargasproh(Class<? extends JugHistoricodescargasproh> type, PathMetadata<?> metadata, PathInits inits) {
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

