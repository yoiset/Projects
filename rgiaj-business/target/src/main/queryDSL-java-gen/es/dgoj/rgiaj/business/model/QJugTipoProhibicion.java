package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugTipoProhibicion is a Querydsl query type for JugTipoProhibicion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugTipoProhibicion extends EntityPathBase<JugTipoProhibicion> {

    private static final long serialVersionUID = -2014970820;

    public static final QJugTipoProhibicion jugTipoProhibicion = new QJugTipoProhibicion("jugTipoProhibicion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<JugProhibicion, QJugProhibicion> jugProhibicionList = this.<JugProhibicion, QJugProhibicion>createList("jugProhibicionList", JugProhibicion.class, QJugProhibicion.class, PathInits.DIRECT);

    public QJugTipoProhibicion(String variable) {
        super(JugTipoProhibicion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJugTipoProhibicion(Path<? extends JugTipoProhibicion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QJugTipoProhibicion(PathMetadata<?> metadata) {
        super(JugTipoProhibicion.class, metadata);
    }

}

