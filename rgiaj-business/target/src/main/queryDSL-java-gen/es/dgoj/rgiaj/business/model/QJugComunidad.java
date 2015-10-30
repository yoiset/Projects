package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugComunidad is a Querydsl query type for JugComunidad
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugComunidad extends EntityPathBase<JugComunidad> {

    private static final long serialVersionUID = -258136466;

    public static final QJugComunidad jugComunidad = new QJugComunidad("jugComunidad");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<JugProvincia, QJugProvincia> jugProvinciaList = this.<JugProvincia, QJugProvincia>createList("jugProvinciaList", JugProvincia.class, QJugProvincia.class, PathInits.DIRECT);

    public QJugComunidad(String variable) {
        super(JugComunidad.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJugComunidad(Path<? extends JugComunidad> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QJugComunidad(PathMetadata<?> metadata) {
        super(JugComunidad.class, metadata);
    }

}

