package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugSituacion is a Querydsl query type for JugSituacion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugSituacion extends EntityPathBase<JugSituacion> {

    private static final long serialVersionUID = 925814981;

    public static final QJugSituacion jugSituacion = new QJugSituacion("jugSituacion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<JugProhibicion, QJugProhibicion> jugProhibicionList = this.<JugProhibicion, QJugProhibicion>createList("jugProhibicionList", JugProhibicion.class, QJugProhibicion.class, PathInits.DIRECT);

    public final StringPath situacionEmp = createString("situacionEmp");

    public final StringPath situacionLocal = createString("situacionLocal");

    public final StringPath situacionMaq = createString("situacionMaq");

    public final StringPath situacionModelo = createString("situacionModelo");

    public final StringPath situacionPersona = createString("situacionPersona");

    public final StringPath tipoSituacion = createString("tipoSituacion");

    public QJugSituacion(String variable) {
        super(JugSituacion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJugSituacion(Path<? extends JugSituacion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QJugSituacion(PathMetadata<?> metadata) {
        super(JugSituacion.class, metadata);
    }

}

