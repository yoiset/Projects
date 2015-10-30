package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProvincia is a Querydsl query type for Provincia
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProvincia extends EntityPathBase<Provincia> {

    private static final long serialVersionUID = -1333111109;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QProvincia provincia = new QProvincia("provincia");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    protected QComunidadAutonoma comunidadAutonoma;

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath matricula = createString("matricula");

    public QProvincia(String variable) {
        this(Provincia.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QProvincia(Path<? extends Provincia> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProvincia(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProvincia(PathMetadata<?> metadata, PathInits inits) {
        this(Provincia.class, metadata, inits);
    }

    public QProvincia(Class<? extends Provincia> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comunidadAutonoma = inits.isInitialized("comunidadAutonoma") ? new QComunidadAutonoma(forProperty("comunidadAutonoma")) : null;
    }

    public QComunidadAutonoma comunidadAutonoma() {
        if (comunidadAutonoma == null){
            comunidadAutonoma = new QComunidadAutonoma(forProperty("comunidadAutonoma"));
        }
        return comunidadAutonoma;
    }

}

