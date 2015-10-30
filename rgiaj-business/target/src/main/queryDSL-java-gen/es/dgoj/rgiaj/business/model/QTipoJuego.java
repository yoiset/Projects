package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTipoJuego is a Querydsl query type for TipoJuego
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoJuego extends EntityPathBase<TipoJuego> {

    private static final long serialVersionUID = -2114704612;

    public static final QTipoJuego tipoJuego = new QTipoJuego("tipoJuego");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QTipoJuego(String variable) {
        super(TipoJuego.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTipoJuego(Path<? extends TipoJuego> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTipoJuego(PathMetadata<?> metadata) {
        super(TipoJuego.class, metadata);
    }

}

